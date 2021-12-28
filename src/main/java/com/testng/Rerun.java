package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun implements IRetryAnalyzer{
	
		int open = 0;
		int quit = 4;

	public boolean retry(ITestResult result) {
		if (open<quit) {
			open++;
			return true;//-----execute
	
}
		
		
		return false;//----execution stop
	}
	

	 
}
