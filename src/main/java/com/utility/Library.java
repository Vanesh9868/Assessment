package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Library {
	
	
	public static void ScrollByPixel(WebDriver driver, int pixel) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,"+pixel+")", "");
		threadSleep(500);
	}
	
	public static void slide(WebDriver driver,int pixel,WebElement slider) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(pixel, 0)
				.release().perform();
	}
	
	
	public static void threadSleep(int timeInMilliseconds) {
		try {
			Thread.sleep(timeInMilliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer getPercentage(int value) {
		int num=(100*value)/2000;
		System.out.println(num);
		return num;
	}
	
	 public static void typeNumber(WebDriver driver, WebElement element, String number) {
	        Actions actions = new Actions(driver);
	        actions.click(element).sendKeys(number).perform();
	    }

}
