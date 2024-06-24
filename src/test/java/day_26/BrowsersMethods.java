package day_26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class BrowsersMethods {
         /*
            BrowsersMethods
            ----------
           driver.quit();  // close all browsers

           driver.close(); // close first tab or window

        */

        public static void main(String[]args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);


            driver.findElement(By.linkText("OrangeHRM, Inc")).click();
            Set<String> WindowHandles = driver.getWindowHandles();
            System.out.println(WindowHandles);

            driver.close(); // close first tab or window
            Thread.sleep(5000);
            driver.quit();  // close all browsers

        }
    }


