package com.domi.testCases;


import org.testng.annotations.Test;

import com.domi.pageObjects.dominosPage;


public class dominosTestCase extends BaseClass
	{

	@Test
	public void login() throws InterruptedException
		{
		
		dominosPage lp = new dominosPage(driver);
		lp.dominos();
  
		}

}
