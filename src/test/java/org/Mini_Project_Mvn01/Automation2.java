package org.Mini_Project_Mvn01;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.POMclass.Page_Object_Manager_Automation;
import com.baseclass.Base_Class;
import com.pom1.Casualdress2;
import com.pom1.Dress2;
import com.pom1.Mystore;
import com.pom1.Printeddress2;
import com.pom1.Tshirts;

public class Automation2 extends Base_Class {
	public static WebDriver driver = browserlaunch("chrome");
	//public static Dress2 d2 = new Dress2(driver);
	//public static Casualdress2 cd2 = new Casualdress2(driver);
	//public static Printeddress2 pd2 = new Printeddress2(driver);
	//public static Mystore ms2 = new Mystore(driver);
	//public static Tshirts ts2 = new Tshirts(driver);
	public static Page_Object_Manager_Automation pom = new Page_Object_Manager_Automation(driver);

	public static void main(String[] args) throws InterruptedException, IOException {

		url("http://automationpractice.com/index.php", "get");

		wait(3);
		jsclick(pom.getD2().getDresses(), "click");

		wait(6);

		jsclick(pom.getCd2().getCasualdress(), "click");
		wait(6);

		jsclick(pom.getPd2().getPrinteddress2(), "click");
		wait(6);

		jsclick(pom.getPd2().getAddtocart2(), "click");
		wait(6);
		jsclick(pom.getPd2().getContinue2(), "click");
	
		wait(6);

		jsclick(pom.getMs2().getMystore(), "click");
		wait(6);

		jsclick(pom.getTs2().getTshirts2(),"click");
		wait(6);

		jsclick(pom.getTs2().getAddtocart3(), "click");
		wait(6);

		jsclick(pom.getTs2().getContinue3(), "click");
		wait(6);
		jsclick(pom.getMs2().getMystore(), "click");
		wait(6);
		
	}

}
