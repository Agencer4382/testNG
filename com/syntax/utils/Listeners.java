package com.syntax.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mongodb.diagnostics.logging.Logger;

public class Listeners extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started : "+result.getName());
		logger=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case success : "+result.getName());
		logger.pass("Test passed : "+result.getName());

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case failed : "+result.getName());
		logger.fail("Test failed : "+result.getName());
		
		String imagePath=CommonMethods.takeScreenshot(result.getName());
		try {
			logger.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped : "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started : "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finished : "+context.getName());
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

}
