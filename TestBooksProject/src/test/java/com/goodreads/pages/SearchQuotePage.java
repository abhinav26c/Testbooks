package com.goodreads.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goodreads.base.BaseClass;

public class SearchQuotePage extends BaseClass {
	
		public SearchQuotePage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		// Finding the best quotes link
		@FindBy(linkText = "Best quotes")
		private WebElement quoteLink;
		public void clickquote()
		{
			quoteLink.click();
		}
		
		//Finding the search text field and entering the text
		@FindBy(id = "explore_search_query")
		private WebElement searchField;
		public String entertext(String UN)
		{
			searchField.clear();
			searchField.sendKeys(UN);
			return UN;
		}
		
		//Finding the search button
		@FindBy(xpath = "//input[@value='Search']")
		private WebElement searchButton;
		public void clicksearch() {
			searchButton.click();
		}
		
		//Clicking the book link after searching the quotes
		@FindBy(linkText = "A Brief History of Time")
		private WebElement booklink;
		public void clickbooklink()
		{
			booklink.click();
		}
	}


