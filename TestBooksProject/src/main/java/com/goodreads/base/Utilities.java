package com.goodreads.base;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;
import org.openqa.selenium.support.ui.FluentWait;;

public class Utilities {

	// *********************************************************************************************************************************//
	// Fluent Wait
	// FluentWait in selenium web driver is one of the most versatile wait which will give you 
	// the complete power to handle any kind of situation based on your requirement.
	public static void callFluentWait(WebDriver driver, final WebElement expectedElement) {

		// Create object of FluentWait class and pass web driver as input
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)			
			.withTimeout(30, TimeUnit.SECONDS)       // Max time for wait- If conditions are not met within this time frame	then it	will fail the script
			.pollingEvery(2, TimeUnit.SECONDS)       // It should poll web element after every 2 seconds
			.ignoring(NoSuchElementException.class); // It ignores NoSuchElementException

		// We are creating Function here which accept input as web driver and output as WebElement
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return expectedElement;
			}
		});
	}

	// *********************************************************************************************************************************//
	// Get list of drop down elements
	public static List<WebElement> getListOfDropdownElements(WebElement webElement) {
		List<WebElement> ListOfDropdownElements = null;
		try {
			Select selectElement = new Select(webElement);
			ListOfDropdownElements = selectElement.getOptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListOfDropdownElements;
	}

	// *********************************************************************************************************************************//
	// Select by Index
	public static void selectDropdownByIndex(WebElement webElement, int index) {
		try {
			Select selectElement = new Select(webElement);
			selectElement.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// *********************************************************************************************************************************//
	// Select by Value
	public static void selectDropdownByValue(WebElement webElement, String value) {
		try {
			Select selectElement = new Select(webElement);
			selectElement.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// *********************************************************************************************************************************//
	// Select by Visible Text
	public static void selectDropdownByVisibleText(WebElement webElement, String visibleText) {
		try {
			Select selectElement = new Select(webElement);
			selectElement.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// *********************************************************************************************************************************//
	// To Take Screenshot
	public static void takeScreenshot(WebDriver driver) {
		try {
			// Convert web driver object to TakeScreenshot(interface)
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Call getScreenshotAs method to create image file
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Destination path with file name
			File destination = new File(
					"./Screenshots/" + driver.getTitle() + "_" + System.currentTimeMillis() + ".png");

			// Copy file at destination
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

	// *********************************************************************************************************************************//
	
}
