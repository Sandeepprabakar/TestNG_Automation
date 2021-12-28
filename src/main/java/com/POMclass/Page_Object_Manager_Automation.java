package com.POMclass;

import org.openqa.selenium.WebDriver;

import com.pom1.Address;
import com.pom1.Casualdress2;
import com.pom1.Dress2;
import com.pom1.Evening_Dress;
import com.pom1.Login;
import com.pom1.Mystore;
import com.pom1.Order;
import com.pom1.Payment;
import com.pom1.Printeddress2;
import com.pom1.Shipping;
import com.pom1.Tshirts;
import com.pom1.printeddress;

public class Page_Object_Manager_Automation {
	public WebDriver driver;
	// public static Dress2 d2 = new Dress2(driver);
	// public static Casualdress2 cd2 = new Casualdress2(driver);
	// public static Printeddress2 pd2 = new Printeddress2(driver);
	// public static Mystore ms2 = new Mystore(driver);
	// public static Tshirts ts2 = new Tshirts(driver);

	private Dress2 d2;
	private Casualdress2 cd2;
	private Printeddress2 pd2;
	private Mystore ms2;
	private Tshirts ts2;
	private Evening_Dress ed;
	private printeddress pd;
	private Order or;
	private Login log;
	private Shipping sh;
	private Payment pay;
	private Address add;

	public Page_Object_Manager_Automation(WebDriver driver2) {
		this.driver = driver2;
	}

	public Dress2 getD2() {
		if (d2 == null) {
			d2 = new Dress2(driver);

		}
		return d2;
	}

	public Casualdress2 getCd2() {
		if (cd2 == null) {
			cd2 = new Casualdress2(driver);

		}
		return cd2;
	}

	public Printeddress2 getPd2() {
		if (pd2 == null) {
			pd2 = new Printeddress2(driver);
		}
		return pd2;
	}

	public Mystore getMs2() {
		if (ms2 == null) {
			ms2 = new Mystore(driver);

		}
		return ms2;
	}

	 
	
	public Tshirts getTs2() {
		if (ts2 == null) {
			ts2 = new Tshirts(driver);

		}
		return ts2;
	}

	
 
	public Evening_Dress getEveningdress() {
		if (ed == null) {
			ed = new Evening_Dress(driver);

		}
		return ed;
	}

	public printeddress getPrinteddress() {
		if (pd == null) {
			pd = new printeddress(driver);
		}
		return pd;
	}

	public Order getOrder() {
		if (or == null) {
			or = new Order(driver);
		}
		return or;
	}

	public Login getLogin() {
		if (log == null) {
			log = new Login(driver);
		}
		return log;
	}

	public Shipping getShipping() {
		if (sh == null) {
			sh = new Shipping(driver);
		}

		return sh;
	}

	public Payment getPayment() {
		if (pay == null) {
			pay = new Payment(driver);
		}
		return pay;
	}

	public Address getAddress() {
		if (add == null) {
			add = new Address(driver);
		}
		return add;
	}

}
