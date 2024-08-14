package com.sample.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//approach to use page object class without using pageFactory
//created page object class
public class Testcase1 {

    WebDriver driver;

    //constructor
    Testcase1(WebDriver driver){
        this.driver = driver;
    }

    //locator
    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_pwd_loc = By.xpath("//input[@placeholder='Password']");
    By txt_login_loc = By.xpath("//button[@type='submit']");
    
    //Action methods
    public void setUserName(String user){
        driver.findElement(txt_username_loc).sendKeys(user);
    }
    public void setPwd(String pwd){
        driver.findElement(txt_pwd_loc).sendKeys(pwd);
    }
    public void clickLogin(){
        driver.findElement(txt_login_loc).click();
    }
}
