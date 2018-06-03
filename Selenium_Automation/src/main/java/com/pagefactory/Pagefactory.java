package com.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Pagefactory {
	
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Sign In')])[2]")
	private WebElement signInbtn;

	public WebElement getSignInbtn() {
		return signInbtn;
	}



	
}
