package day_29;

/*
 there are 3 type of alert
 1- normal alert (has one button )
 2- confirmation alert (has two button )
 3- pormpt alert (has input field and two button)
 note: alert not webElement
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main (String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1)handel normal alert
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        //1-direct way
        //driver.switchTo().alert().accept();

        //2-more option (create abject and operate on it)
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());
        myAlert.accept();


        //2) confirmation alert (has two button )
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(5000);

        //driver.switchTo().alert().accept();   // close alert by click on ok Button

        driver.switchTo().alert().dismiss();  // close alert by click on cancel Button

        //3) pormpt alert (has input field and two button)
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);

        Alert proptAlert = driver.switchTo().alert();
        proptAlert.sendKeys("Welcome");
        proptAlert.accept();

        //NOTE : can handel any type of alert using explicit wait
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        myAlert = myWait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();

        // handel Authentication popup alert

        // by injection username and password with url
        // syntax :https://username:password@the-internet.herokuapp.com/basic_auth


        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");



    }
}
