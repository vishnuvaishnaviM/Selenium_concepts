package com.sample.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//listeners
public class TestNG9 implements ITestListener { // to view all the default methods of ITestListener interface - click on the ctrl+ITestListener
    //copied all the below 6 methods definition from the default listener ITestListener
    public void onStart(ITestContext context) { //will run only once before starting test cases execution
        System.out.println("test execution started..........");
    }
    public void onTestStart(ITestResult result) { // will run before each test case
        System.out.println("test started...........");
   }

   public void onTestSuccess(ITestResult result) { //will run on each testcase success
    System.out.println("test passed...........");
   }

   public void onTestFailure(ITestResult result) { // will run on each test case failure
    System.out.println("test failed..........");
   }

   public void onTestSkipped(ITestResult result) { //will run when a test case is skipped
    System.out.println("test skipped.............");
   }
   public void onFinish(ITestContext context) {
    System.out.println("test execution completed........");
   }
    
}
