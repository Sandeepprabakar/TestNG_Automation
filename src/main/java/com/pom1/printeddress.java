package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class printeddress {
	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='View larger']")
	private WebElement larger;
	
	@FindBy(xpath="//a[@title='Close']")
	private WebElement close;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	private WebElement icon;
	
	@FindBy(xpath="//select[@class='form-control attribute_select no-print']")
	private WebElement size;
	
	@FindBy(xpath="//a[@name='Pink']")
	private WebElement colour;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private	WebElement cart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement checkout;
	
	@FindBy(xpath="//b[text()='Cart']")
	private WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}

	public printeddress(WebDriver driver2) {
		this.driver= driver2;
		PageFactory.initElements(driver, this);	}

	public WebElement getLarger() {
		return larger;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getIcon() {
		return icon;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getColour() {
		return colour;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getCheckout() {
		return checkout;
	}
	
	
	
	

}
