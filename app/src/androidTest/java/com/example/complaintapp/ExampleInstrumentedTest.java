package complianApp;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.google.common.base.*;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class testApp {
	
	static AppiumDriver<MobileElement> driver;
	public static void main (String args[])  {
		try {
			openApp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void openApp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName" , "12345");
		cap.setCapability("udid", "a78eb130"); 
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability("appPackage", "com.example.complaintapp");
		cap.setCapability("appActivity", "com.example.complaintapp.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5	, TimeUnit.SECONDS);
		
		//createAccountCitizen("bhautik" , "8154874222" ,"da201701159@gmail.com" , "12345652");
		driver.manage().timeouts().implicitlyWait(5	, TimeUnit.SECONDS);
		//loginCitizen("da201701159@gmail.com" , "12345652");
		registerComplaint();

		Thread.sleep(5000);
		
	}
	public static void createAccountCitizen(String username , String phoneNo , String Email ,String Password) {
		// still remining 
		
		click("com.example.complaintapp:id/Create_Account");
		type("com.example.complaintapp:id/Citizen_User_Name" , username);
		type("com.example.complaintapp:id/Citizen_Phone_Number" , phoneNo);

		type("com.example.complaintapp:id/Citizen_Email" , Email);

		type("com.example.complaintapp:id/Citizen_Password" , Password);

		click("com.example.complaintapp:id/Citizen_Sign_Up");
	}
	public static void createAccountCorporation(String username , String phoneNo , String Email ,String Password) {
		click("com.example.complaintapp:id/Create_Account");
		type("com.example.complaintapp:id/Citizen_User_Name" , username);
		type("com.example.complaintapp:id/Citizen_Phone_Number" , phoneNo);

		type("com.example.complaintapp:id/Citizen_Email" , Email);

		type("com.example.complaintapp:id/Citizen_Password" , Password);

		click("com.example.complaintapp:id/Citizen_Sign_Up");
	}
	public static void loginCorporation() {
		// still remaining
		click("com.example.complaintapp:id/Register_Corporation");
		
	}
	
	
	public static void loginCitizen(String Email  ,String password) {
		type("com.example.complaintapp:id/Login_Citizen_Email" , Email);
		type("com.example.complaintapp:id/Login_Citizen_Password" , password);
		click("com.example.complaintapp:id/Login_Button");
	}
	public static void click(String id) {
		MobileElement button = driver.findElement(By.id(id));
		button.click();
	}
	
	public static void registerComplaint() {
		loginCitizen("da201701159@gmail.com" , "12345652");
		driver.findElement(By.name("Views")).click();
		  // Scroll till element which contains "Spinner" text.
		

	}
	
	public static void type(String id , String val ) {
		MobileElement text = driver.findElement(By.id(id));
		text.sendKeys(val);

	}
	
	static void debug(Object...o) {
		System.out.println(Arrays.deepToString(o));
	}
}
