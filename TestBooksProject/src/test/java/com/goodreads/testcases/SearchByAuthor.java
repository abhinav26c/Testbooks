package com.goodreads.testcases;

import org.testng.annotations.Test;

import com.goodreads.base.BaseClass;
import com.goodreads.pages.SearchPage;

import junit.framework.Assert;

public class SearchByAuthor extends BaseClass{
	
	
	//Search By Author
		@Test
		public void SearchAuthor(){
		SearchPage sp = new SearchPage(driver);
		
		//get the author name from excel sheet
		String result1 = sp.entertext(xls.getCellData("Search", "Searchtext", 2));
		
		Assert.assertEquals("Stephen Hawking", result1);
			
		//click on search button
		sp.clicksearch();
			
		}
	}




