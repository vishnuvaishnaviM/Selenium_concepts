package com.sample.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//approach to use page object class - using pageFactory
//created page object class
public class Testcase3 {

    WebDriver driver;

    //constructor
    Testcase3(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locator
    @FindBy(xpath = "//input[@placeholder='Username']") WebElement txt_username_loc;
    @FindBy(xpath = "//input[@placeholder='Password']") WebElement txt_pwd_loc;
    @FindBy(xpath = "//input[@placeholder='submit']") WebElement txt_login_loc;
    
    
    //Action methods
    public void setUserName(String user){
        txt_username_loc.sendKeys(user);
    }
    public void setPwd(String pwd){
        txt_pwd_loc.sendKeys(pwd);
    }
    public void clickLogin(){
        txt_login_loc.click();
    }
}
