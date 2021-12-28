package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
	public WebDriver driver;

	@FindBy(id="cgv")
	private WebElement radiobutton;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement checkout;

	public Shipping(WebDriver driver2) {
		this.driver= driver2;
		PageFactory.initElements(driver, this);	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getCheckout() {
		return checkout;
	}
	
}
