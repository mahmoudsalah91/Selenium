package day_21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
    Test case
    ---------
    1-open Chrome browser
    2-open URL https://demo.opencart.com/
    3-validate title should be  "Your Store"
    4-close browser
     */
public class FirstTestCase {

    public static void main(String[] args){

       // 1-open Chrome browser

        //by creating object from child class (ChromeDriver class )
        //ChromeDriver driver = new ChromeDriver();

        //by creating object from parent class ( WebDriver ) store parent class (up casting)
        WebDriver driver = new ChromeDriver();


       // 2-open URL https://demo.opencart.com/
        driver.get("https://demo.opencart.com/");


        //3-validate title should be  "Your Store"
       String actualTitle=driver.getTitle();
        System.out.println(actualTitle);

        if(actualTitle.equals("Your Store") ){
            System.out.println("Test Pass ");
        }
        else{
            System.out.println("Test failed");
        }

        //4-close browser

        driver.close();  // close browser
        //driver.quit();   // close all browser

    }
}
