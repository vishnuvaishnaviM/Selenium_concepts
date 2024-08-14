package com.sample;
import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Selenium16 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Ensure you have successfully switched to the frame
        driver.switchTo().frame("frame-one796456169");
        System.out.println("Switched to frame successfully");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Click on calendar icon
            WebElement calendarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon_calendar']")));
            calendarIcon.click();
            calendarIcon.click();
            System.out.println("Clicked on calendar icon");

            String reqYear = "2023";
            String reqMonth = "June";
            String reqDate = "24";

            // Select year
            WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
            scrollToElement(driver, year);
            Select selectYear = new Select(year);
            selectYear.selectByVisibleText(reqYear);
            System.out.println("Year selected");

            // Select month
            while (true) {
                String actMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                Month aMonth = stringToMonth(actMonth);
                Month exMonth = stringToMonth(reqMonth);

                int res = exMonth.compareTo(aMonth);
                if (res < 0) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                } else if (res > 0) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                } else {
                    break;
                }
            }

            // Select date
            List<WebElement> dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
            for (WebElement dt : dateList) {
                if (dt.getText().equals(reqDate)) {
                    scrollToElement(driver, dt);
                    dt.click();
                    break;
                }
            }
            System.out.println("Date selected");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static Month stringToMonth(String month) {
        HashMap<String, Month> monthmap = new HashMap<>();
        monthmap.put("January", Month.JANUARY);
        monthmap.put("February", Month.FEBRUARY);
        monthmap.put("March", Month.MARCH);
        monthmap.put("April", Month.APRIL);
        monthmap.put("May", Month.MAY);
        monthmap.put("June", Month.JUNE);
        monthmap.put("July", Month.JULY);
        monthmap.put("August", Month.AUGUST);
        monthmap.put("September", Month.SEPTEMBER);
        monthmap.put("October", Month.OCTOBER);
        monthmap.put("November", Month.NOVEMBER);
        monthmap.put("December", Month.DECEMBER);

        return monthmap.get(month);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
