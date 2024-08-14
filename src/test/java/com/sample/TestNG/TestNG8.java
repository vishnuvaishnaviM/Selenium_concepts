package com.sample.TestNG;
//Data provider for parallel testing

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(com.sample.TestNG.TestNG9.class) // to implement listener to a specific class without help of testng.xml file
public class TestNG8 {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) throws InterruptedException{
        switch(br.toLowerCase()){
            case "chrome": driver=new ChromeDriver(); break;
            case "edge": driver= new EdgeDriver();break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("invalid browser"); return;
        }

        // driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(10000);
    }

    @Test(priority=1)
    void testcase1(){
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(status, true);
    }
    
    @Test(priority=2)
    void testcase2(){
        Assert.assertEquals(driver.getTitle() , "OrangeHRM");
    }
    @Test(priority=3)
    void testcase3(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
    
}
