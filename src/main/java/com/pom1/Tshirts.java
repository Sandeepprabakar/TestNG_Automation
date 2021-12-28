package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tshirts {
	public WebDriver driver;
	
	
	public Tshirts(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}


	public WebElement getTshirts2() {
		return tshirts2;
	}


	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tshirts2;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addtocart3;
	
	public WebElement getAddtocart3() {
		return addtocart3;
	}


	public WebElement getContinue3() {
		return continue3;
	}


	@FindBy(xpath="//i[@class='icon-chevron-left left']")
	private WebElement continue3;
	
	
	

}
