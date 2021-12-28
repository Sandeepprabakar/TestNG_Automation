
package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Printeddress2 {
	public WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Printed Dress')]")
	private WebElement printeddress2;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addtocart2;
	
	@FindBy(xpath="//i[@class='icon-chevron-left left']")
	private WebElement continue2;

	public WebElement getContinue2() {
		return continue2;
	}

	public WebElement getAddtocart2() {
		return addtocart2;
	}

	public Printeddress2(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	
	
	}

	public WebElement getPrinteddress2() {
		return printeddress2;
	}
	
	
	
	
	
	
	
}
