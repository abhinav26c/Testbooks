package com.goodreads.testcases;

import org.testng.annotations.Test;

import com.goodreads.base.BaseClass;
import com.goodreads.pages.SearchQuotePage;

import junit.framework.Assert;

public class SearchByQuote extends BaseClass {
	
	@Test
	public void SearchBookByQuote()
	{
		SearchQuotePage sq = new SearchQuotePage(driver);
		
		//click on best quote link
		sq.clickquote();
		
		//get quote from excel and paste it to search field
		String actual= sq.entertext(xls.getCellData("Search","SearchQuote", 2));
		Assert.assertEquals("mathematical model cannot answer the questions of why there should", actual);
		
		
		
		// click on search button
		sq.clicksearch();
		
		//click on the book link
		sq.clickbooklink();
	}

}
