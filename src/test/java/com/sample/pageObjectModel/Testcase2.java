package com.sample.pageObjectModel;
//writing test case using page object class of testcase1 and testcase3

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Testcase2 {

    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin(){
        Testcase1 tc1 = new Testcase1(driver);
        tc1.setUserName("Admin");
        tc1.setPwd("admin123");
        tc1.clickLogin();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
    
}
