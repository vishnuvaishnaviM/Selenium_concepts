package com.sample.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//Data providers
//since there is no valid login credentials created for the below website none of the website will clear the true condition
import org.testng.annotations.DataProvider;
public class TestNG7 {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //I want to implement this testLogin on different sets of data without using looping - using DataProvider
    @Test(dataProvider="dp")
    void testLogin(String email, String password) throws InterruptedException{
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(5000);
        boolean status = driver.findElement(By.xpath("//h2[normalize-space='My account']")).isDisplayed();
        if(status==true){
            driver.findElement(By.xpath("null")).click();
            Assert.assertTrue(true);

        }
        else{
            Assert.fail();
        }
    }
    @AfterClass
    void teardown(){
        driver.quit();
    }

    // @DataProvider(name="dp") //give some name to the data provider
    @DataProvider(name="dp", indices={0,1}) //give some name to the data provider, to take input data from specific indices
    Object[][] loginData(){
        Object[][] data = {
            {"abc@gmail.com","test123"},
            {"xyz@gmail.com","abc@123"},
            {"zwer@gmail.com","sfr1234"},
            {"bvfbe@gmail.com","9789ybkkk"}
        };
        return data;
    }
    
}
