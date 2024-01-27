package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.setProperty("webDriver.chrome.driver","D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aa.com/homePage.do");
        driver.manage().window().maximize();

        // FROM

        driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm']/div[3]/div[1]/div/a/span[1]")).click();
        Select s1 = new Select(driver.findElement(By.xpath("//*[@id='countryCode']")));
        s1.selectByValue("US");
        Select s2 = new Select(driver.findElement(By.xpath("//*[@id='stateCode']")));
        s2.selectByValue("CA");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"airport_BFL\"]/span[1]")).click();

        // TO

        driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[3]/div[2]/div/a/span[1]")).click();
        Select s3 = new Select(driver.findElement(By.xpath("//*[@id='countryCode']")));
        s3.selectByValue("US");
        Select s4 = new Select(driver.findElement(By.xpath("//*[@id='stateCode']")));
        s4.selectByValue("NY");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"airport_BUF\"]/span[1]")).click();

        // NUMBER OF PASSENGERS

        Select s5 = new Select(driver.findElement(By.xpath("//*[@id=\"flightSearchForm.adultOrSeniorPassengerCount\"]")));
        s5.selectByValue("2");

        // Depart

        driver.findElement(By.id("aa-leavingOn")).sendKeys("02/5/2024");

        // RETURN

        driver.findElement(By.id("aa-returningFrom")).sendKeys("02/15/2024");

        // SEARCH

        driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

    }
}