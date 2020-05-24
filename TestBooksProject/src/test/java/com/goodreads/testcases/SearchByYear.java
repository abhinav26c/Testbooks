package com.goodreads.testcases;


import org.testng.annotations.Test;

import com.goodreads.base.BaseClass;
import com.goodreads.pages.SearchYearPage;



public class SearchByYear extends BaseClass {
	@Test
	public void SearchYear(){
		SearchYearPage sp = new SearchYearPage(driver);
	
	//get the year from excel sheet
	sp.entertext(xls.getCellData("Search", "SearchYear", 2));
	
	
		
	//click on search button
	sp.clicksearch();
		
	}
}
