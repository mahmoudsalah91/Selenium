package day_27;

        /*

        why we need waiting : to overcome the synchronization problem

        synchronization problem: is through exception as the speed of execution automation script faster than web response
        there are 2 type of exception related this problem
        1- NoSuchElementException : happen when element is not present in the page to interact at this time (synchronization problem)
        2- ElementNotFound  : happen when locator is in-correct

        Waiting types
        ------------
        there are 2 types of waiting
        1-related to java not to selenium
        Thread.sleep();
        - Advantage of sleep : easy to use
        - Disadvantage : if the time for wait not sufficient will get exception
                       : if time for wait long it will waste the time Affected on performance
                       : you need write multiple times

        2-related to selenium webdriver

        1-Implicit wait: it is global on all driver under this statement >> driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        -Adv:
        single time statement
        it will not wait till maximum time if element available
        applicable for all elements
        easy to use

        -Disadvantage:
        if the time for wait not sufficient will get exception

        2-Explicit wait : it is specific for an element depend on conditions
        need two steps to use :1-declaration 2-use statement for each element you want
        1-declaration >> by make an object from class of WebDriverWait that contain constructor take two local variables (driver,Duration.ofSecond())
        2-use statement >> by store a condition and element locator in webElement variable

        -Adv:
        1-conditional based
        2-finding element is inclusive in use statement
        3-wait for condition to be true ,then consider the wait time

        3-Fluent wait: it is advanced smart wait
        need several steps to Declaration and use statement so take it from Documentation
        the idea for use that it set time for wait and time for check the element during waiting time
        ex: waiting time 30 s , check time 5 s that mean during 30 s each 5 s driver check element

         */

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitingTypes {

    public static void main(String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //1-Thread.sleep()
        //Thread.sleep(3000);

        //2-implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        //3-Explicit wait
        /*
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10)); //>> Declaration
        WebElement userTxt = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        userTxt.sendKeys("Admin"); //>> use statement
        */



        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

                WebElement userTxt1 = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }

        });
                userTxt1.sendKeys("Admin");



    }
}
