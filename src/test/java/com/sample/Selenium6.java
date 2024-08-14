package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium6 {
    public static void main(String[] args) {
        WebDriver driver = null;
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver = new ChromeDriver();
                WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                driver.manage().window().maximize();
                
                myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("username");
                myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
                break; // Exit loop if successful
            } catch (Exception e) {
                attempts++;
                if (attempts == 3) {
                    e.printStackTrace(); // Log the error on the third attempt
                } else {
                    System.out.println("Retrying... Attempt " + attempts);
                }
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }
}
