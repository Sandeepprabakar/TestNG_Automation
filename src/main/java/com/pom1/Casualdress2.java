package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Casualdress2 {
	public WebDriver driver;

	@FindBy(xpath = "(//a[contains(text(),'Casual Dresses')])[3]")
	private WebElement casualdress;

	public Casualdress2(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getCasualdress() {
		return casualdress;
	}

}
