package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Library;

import java.time.Duration;

public class test1 {

	public static void main(String[] args) {
		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 1: Navigate to Revenue Calculator Page
		WebElement revenueCalculator = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		revenueCalculator.click();

		// Step 2: Scroll down to the Slider section
		for (int i = 0; i < 10; i++) {
			Library.ScrollByPixel(driver, 500);
		}

		// Step 3: Adjust the Slider
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']")); // Modify as needed

		Library.slide(driver, 100, slider); // Slide right
		Integer max = Integer.parseInt(slider.getAttribute("value"));

		Library.slide(driver, -50, slider); // Slide left
		Integer min = Integer.parseInt(slider.getAttribute("value"));

		if (max > min) {
			System.out.println("Sliding correct!!");
		} else {
			System.out.println("Sliding incorrect!!");
		}

		// Set and validate the slider value
		String expectedSlide = "529";
		WebElement inputSlide = driver.findElement(By.xpath(
				"//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));

		inputSlide.clear();
		inputSlide.sendKeys(String.valueOf(expectedSlide));

		String actualSlide = slider.getAttribute("value");
		System.out.println("Actual Slider Value: " + actualSlide);

		if (expectedSlide.equals(actualSlide)) {
			System.out.println("Slider value updated correctly!!");
		} else {
			System.out.println("Slider value update incorrect!!");
		}

		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")).click();

		String TotalRecurringReimbursement = driver
				.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]"))
				.getText();

		System.out.println("TotalRecurringReimbursement" + TotalRecurringReimbursement);

		driver.close();
	}
}
