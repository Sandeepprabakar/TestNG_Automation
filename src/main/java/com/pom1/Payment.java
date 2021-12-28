package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	public WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	private WebElement pay;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirm;
	
	@FindBy(xpath="(//a[contains(text(),'Sign out')])[1]")
	private WebElement signout;
	
	public WebElement getSignout() {
		return signout;
	}

	public Payment(WebDriver driver2) {
		this.driver= driver2;
		PageFactory.initElements(driver, this);	}

	public WebElement getPay() {
		return pay;
	}

	public WebElement getConfirm() {
		return confirm;
	}
	
	
	
	
}
