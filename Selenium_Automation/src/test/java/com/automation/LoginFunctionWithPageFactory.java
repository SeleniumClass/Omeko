package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.LoginPageFactory;
import com.util.HighLighter;
import com.util.TakeScreenShot;

public class LoginFunctionWithPageFactory {

	static WebDriver driver;
	static LoginPageFactory pf;

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://www.gcrit.com/build3/");
		pf = PageFactory.initElements(driver, LoginPageFactory.class);

		pf.getMyAccountloginBtn().click();

		String loginPageTitle = pf.getLoginPageTitle().getText();
		System.out.println(loginPageTitle);
		Thread.sleep(1500);

		pf.getUserName().sendKeys("your name");
		Thread.sleep(1500);
		pf.getPassword().sendKeys("your pass");
		Thread.sleep(1500);
		pf.getSignInbtn().click();

		if (pf.getLoginSuccessTitle().getSize().getHeight() > 0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginSuccessTitle());
			System.err.println("Login success ::" + pf.getLoginSuccessTitle().getText());
			Thread.sleep(1500);
		} else if (pf.getLoginFailTitle().getSize().getHeight() > 0) {
			HighLighter.getDrawRedColor(driver, pf.getLoginFailTitle());
			System.err.println("Login failed ::" + pf.getLoginFailTitle().getText());
			Thread.sleep(1500);
		} else {
			System.out.println("Something wrong in login>>>> check screen shot");
		}
		TakeScreenShot.captureScreenShot(driver, "Home page");

		driver.quit();

	}

}
