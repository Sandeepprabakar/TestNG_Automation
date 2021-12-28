package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mystore {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@title='My Store']")
	private WebElement mystore;

	public Mystore(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getMystore() {
		return mystore;
	}

}
