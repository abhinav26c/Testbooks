package com.goodreads.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public SearchPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Finding the search text field
	@FindBy(id = "sitesearch_field")
	private WebElement searchField;
	public String entertext(String UN)
	{
		searchField.clear();
		searchField.sendKeys(UN);
		return UN;
	}
	
	//Finding the search button
	@FindBy(xpath = "//img[@title='Title / Author / ISBN']")
	private WebElement searchButton;
	public void clicksearch() {
		searchButton.click();
	}
}

