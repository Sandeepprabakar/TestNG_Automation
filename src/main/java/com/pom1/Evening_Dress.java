package com.pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Evening_Dress {
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Women']")
	private WebElement women;

	public WebElement getWomen() {
		return women;
	}

	@FindBy(xpath = "//a[contains(text(),'Printed Dress')]")
	private WebElement printeddress;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[2]/a")
	private WebElement Dresses;
	
	
	public WebElement getDresses() {
		return Dresses;
	}

	public WebElement getEvening() {
		return evening;
	}

	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[2]/a")
	private WebElement evening;
	
	public Evening_Dress(WebDriver driver2) {
		this.driver= driver2;
		PageFactory.initElements(driver, this);	}
	
	public WebElement getPrinteddress() {
		return printeddress;
	}
	
	

}
