package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//uploading single and multiple files
public class Selenium20 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        System.out.println(System.getProperty("user.dir"));
        //upload single file
        WebElement button = driver.findElement(By.xpath("//input[@id='filesToUpload']")); 
        button.sendKeys(System.getProperty("user.dir")+"\\test_data\\new.xlsx");
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("new.xlsx")){
            System.out.println("file uploaded successfully");
        }else{
            System.out.println("file upload failed");
        }

        //upload multiple files
        String file1 = System.getProperty("user.dir")+"\\test_data\\new.xlsx";
        String file2 = System.getProperty("user.dir")+"\\test_data\\data1.xlsx";
        button.sendKeys(file1 +"\n"+file2);
        int nooffiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
        if(nooffiles==3){
            System.out.println("multiple files uploaded successfully");

        }else{
            System.out.println("upload failed");
        }
        driver.quit();
    }
    
}
