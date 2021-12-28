package org.Mini_Project_Mvn01;

import static org.testng.Assert.assertEquals;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.POMclass.Page_Object_Manager_Automation;
import com.baseclass.Base_Class;
import com.helper.File_Reader_Manager;
import com.pom1.Address;
import com.pom1.Evening_Dress;
import com.pom1.Login;
import com.pom1.Order;
import com.pom1.Payment;
import com.pom1.Shipping;
import com.pom1.printeddress;
import com.testng.Rerun;

public class Testng_Runner_Class extends Base_Class {
	static Logger log = Logger.getLogger(Testng_Runner_Class.class);

	public static WebDriver driver = browserlaunch("chrome");

	public static Page_Object_Manager_Automation pom = new Page_Object_Manager_Automation(driver);

	@BeforeClass
	private void Browser() throws Throwable {

		PropertyConfigurator.configure("log4j.properties");

		String url = File_Reader_Manager.filereadermanager().configurationreader().geturl();

		url(url, "get");
		wait(8);

		log.info("Session created");
		String driver1 = driver1("currenturl");
		System.out.println(driver1);
		

		wait(5);
	}

	@BeforeMethod
	private void signin() throws Throwable {

		jsclick(pom.getLogin().getSignin(), "click");
		wait(5);
		String particulardata = Particulardata(
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Mini_Project_Mvn\\testcases.xlsx", 0, 10, 5);

		inputelement(pom.getLogin().getEmail(), particulardata);
		String particulardata2 = Particulardata(
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Mini_Project_Mvn\\testcases.xlsx", 0, 11, 5);

		inputelement(pom.getLogin().getPassword(), particulardata2);

		clickonelement(pom.getLogin().getSubmit());

		wait(10);
		log.info("Successfully logged in");
	}

	@Test(priority = -1,invocationCount = 2)
	private void dresses() throws Throwable {
		String title1 = driver1("title");
		System.out.println(title1);
		

		jsclick(pom.getD2().getDresses(), "click");

		wait(6);

		jsclick(pom.getCd2().getCasualdress(), "click");
		wait(6);

		jsclick(pom.getPd2().getPrinteddress2(), "click");
		wait(6);

		jsclick(pom.getPd2().getAddtocart2(), "click");
		wait(6);
		jsclick(pom.getPd2().getContinue2(), "click");
		String driver2 = driver1("currenturl");
		System.out.println(driver2);
		String title2 = driver1("title");
		System.out.println(title2);
		
		Assert.assertNotEquals(title1, title2);
	}
	
	@Test(priority = 1)
	private void tshirts() throws Throwable {

		jsclick(pom.getTs2().getTshirts2(), "click");
		wait(6);

		jsclick(pom.getTs2().getAddtocart3(), "click");
		wait(6);
		
		jsclick(pom.getPd2().getContinue2(), "click");

		wait(8);

		String title3 = driver1("title");
		System.out.println(title3);
		
	}

	@Test(priority = 0,dependsOnMethods = "dresses" )
	private void eveningdress() throws Throwable {

		clickonelement(pom.getEveningdress().getWomen());
		wait(5);

		clickonelement(pom.getEveningdress().getDresses());
		wait(3);
		clickonelement(pom.getEveningdress().getEvening());
		wait(5);

		jsclick(pom.getEveningdress().getPrinteddress(), "click");

		wait(5);
		clickonelement(pom.getPrinteddress().getLarger());
		wait(8);

		clickonelement(pom.getPrinteddress().getClose());
		wait(8);

		for (int i = 0; i < 2; i++) {

			mouseaction(pom.getPrinteddress().getIcon(), "doubleclick");

		}
		dropdown(pom.getPrinteddress().getSize(), "index", "1");

		clickonelement(pom.getPrinteddress().getCart());

		Thread.sleep(8000);
		screenshot("automationpom1");
		jsclick(pom.getPd2().getAddtocart2(), "click");
		wait(6);
		jsclick(pom.getPd2().getContinue2(), "click");

		wait(8);
		String title4 = driver1("title");
		System.out.println(title4);
	}
	@AfterMethod
	private void checkout() {
		jsclick(pom.getPrinteddress().getAddtocart(), "click");
		wait(6);
		clickonelement(pom.getOrder().getCheckout());
		wait(10);

		clickonelement(pom.getAddress().getCheckout());

		
		
		wait(10);

		clickonelement(pom.getShipping().getRadiobutton());

		wait(6);

		clickonelement(pom.getShipping().getCheckout());
		wait(6);

		clickonelement(pom.getPayment().getPay());

		wait(4);
		clickonelement(pom.getPayment().getConfirm());
		log.fatal("Successfully booked");
		
		jsclick(pom.getPayment().getSignout(), "click");
		log.fatal("logged out");

	}
	
	
	@AfterClass
	private void close() {
		driver1("close");
		
	}

}
