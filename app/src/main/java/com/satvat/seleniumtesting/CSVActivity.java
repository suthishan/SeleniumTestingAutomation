package com.satvat.seleniumtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.opencsv.CSVReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CSVActivity  {
   public WebDriver driver;

    private String CSV_PATH="C:\\Users\\suthishan\\Desktop\\CSV Pack\\CSV Pack\\Detail.csv";
//    private WebDriver driver;

    @BeforeTest
    public void setup() {
//        WebDriver driver;

        String exePath = "D:\\Softwares\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
    }
    //WebDriver driver;

    @Test
    public void csvDataRead() throws IOException {
//        String exePath = "D:\\Softwares\\chromedriver_win32\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", exePath);
//        driver = new ChromeDriver();
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String [] csvCell;
        //while loop will be executed till the last line In CSV.
        while ((csvCell = reader.readNext()) != null) {

            String FName = csvCell[0];
            System.out.println(FName);
            String LName = csvCell[1];
            System.out.println(LName);
            String Email = csvCell[2];
            System.out.println(Email);
            String Mob = csvCell[3];
            System.out.println(Mob);
            String company = csvCell[4];
            System.out.println(company);

            driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
            driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
            driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
            driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(Mob);
            driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(company);
            driver.findElement(By.xpath("//input[@value='Submit']")).click();
            driver.switchTo().alert().accept();

        }
    }

}
