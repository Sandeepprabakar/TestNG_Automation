package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver driver;
	public static Select rt;
	public static String value;
	
	//-------------------------------------Browser_Launch--------------------------------------------------------------------------------------

	public static WebDriver browserlaunch(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (type.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\ie.exe");

			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser Mismatch");
		}

		driver.manage().window().maximize();
		return driver;

	}
//	----------------------------------------------------URL---------------------------------------------------------------------------------------

	public static void url(String url,String type) {
		if (type=="get") {
			driver.get(url);
			}
		else if (type=="navigate") {
			driver.navigate().to(url);
			
		}
	}
	//------------------------------------------------------Navigate--------------------------------------------------------------------------------

	public static void navigate(String type) {
		if (type=="back") {
			driver.navigate().back();
		}
		else if (type=="refresh") {
			driver.navigate().refresh();
			}
		else if (type=="forward") {
			driver.navigate().forward();
			
		} 

	} 
	//---------------------------------------------------------Driver--------------------------------------------------------------------------------
	public static String driver1( String type) {
		if (type=="currenturl") {
			String Url = driver.getCurrentUrl();
			return Url;
		}
		else if (type=="title") {
			String title = driver.getTitle();
			return title;
		}
		else if (type=="quit") {
			driver.quit();
			
		}
		else if (type=="close") {
			driver.close();
			}
		return type;}
	//------------------------------------------------------------Webelement----------------

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void clickonelement(WebElement element) {

		element.click();

	}

	public static void inputelement(WebElement element, String value) {

		element.sendKeys(value);

	}
	//----------------------------------------------Datadriven----------------------------------
	public static  String Particulardata(String path,int index,int row_Index,int cell_Index) throws IOException {
		File f = new File(path);
		FileInputStream fa = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fa);

		Sheet sheet = w.getSheetAt(index);
		Row row = sheet.getRow(row_Index);
		Cell cell = row.getCell(cell_Index);
		CellType cellType = cell.getCellType();
		if (cellType.equals(cellType.STRING)) {
			value = cell.getStringCellValue();
		} else if (cellType.equals(cellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int i = (int) numericCellValue;
			value = String.valueOf(i);

		}
		return value;
	}
	//-----------------------------------------------Wait---------------------------------------------------------------------------------------

	public static void wait(int secs) {

		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);

	}
//-----------------------------------------------------Actions------------------------------------------------------------------------------------
	public static void mouseaction(WebElement element, String str) {
		Actions act = new Actions(driver);

		if (str.equalsIgnoreCase("left")) {
			act.click(element).build().perform();
		}
		if (str.equalsIgnoreCase("right")) {
			act.contextClick(element).build().perform();
		}
		if (str.equalsIgnoreCase("doubleclick")) {
			act.doubleClick(element).build().perform();
		}
		if (str.equalsIgnoreCase("move")) {
			act.moveToElement(element).build().perform();
		}
	}

	public static void mouseaction(WebElement element , WebElement element1 ) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element1);
		
}
	//-----------------------------------------------------Frame---------------------------------------------------------------------------
	public static void frameselection(WebElement element) {
		driver.switchTo().frame(element);
	}
	//----------------------------------------------------Alert-----------------------------------------------------------------------------------------
	
	public static void alerthandling(String str) {
		Alert alert = driver.switchTo().alert();
		
		if (str.equalsIgnoreCase("accept")) {
			alert.accept();
		}
		if (str.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}	
	}
	
	
	public static void alerthandling(String str, String str1) {
		Alert alert = driver.switchTo().alert();
			alert.sendKeys("str1");
		
	}
	//-------------------------------------------------------Robot-------------------------------------------------------------------------------------
	
	public static void Robot(String str) throws AWTException {
		Robot r =new Robot();
		
		if (str.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
		}

		if (str.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			
		}
	
		if (str.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		}
	}
	//--------------------------------------------------------------Dropdown-------------------------------------------------------------------------
	
	public static void dropdown(WebElement element, String type, String value) {
		rt = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			rt.selectByIndex(parseInt);
		} else if (type.equalsIgnoreCase("value")) {
			rt.selectByValue(value);

		} else if (type.equalsIgnoreCase("text")) {
			rt.selectByVisibleText(value);
		} else if (type.equalsIgnoreCase("multiple")) {
			boolean multiple = rt.isMultiple();
			System.out.println(multiple);
		}

		}
		public static void boolean1(WebElement element1, String type1) {
			if (type1=="enabled") {
				boolean selected = element1.isEnabled();
				}
			else if (type1=="displayed") {
				boolean displayed = element1.isDisplayed();
			}
			else if (type1=="selected") {
				boolean selected = element1.isSelected();
			}
		}

	
	//-----------------------------------------------------------------Javascript--------------------------------------------------------------------

	public static void jsclick(WebElement element, String type) {
		if (type=="click") {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			
		}
		if (type=="scrollinto") {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);	
		}
		

	}

	

	public static void jsscroll(int b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+b +"); ");

	}
	
	public void jsdraganddrop() {

	}
	//----------------------------------------------------------------------Screenshot--------------------------------------------------------------

	public static void screenshot(String b) throws IOException {
		TakesScreenshot str = (TakesScreenshot) driver;

		File source = str.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Selenium_Basic\\screenshot\\" + b + ".png");

		FileUtils.copyFile(source, destination);
	}
	public static void loop(int value,WebElement element) {
		for (int i = 0; i < value; i++) {
			clickonelement(element);
			
		}}
	//-----------------------------------------------------------Window_Handles-----------------------------------------------------------------------
	
	public static void currentwindowtitle() {
		String windowHandle = driver.getWindowHandle();
}


public static void allthewindowtitles() {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String str : windowHandles) {
			String title = driver.switchTo().window(str).getTitle();
			System.out.println(title);
			
		}
}
	

}

