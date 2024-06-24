package day_28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;


        /*
        navigational commands
        _____________________

        1-navigate().to() : function open url
        note :
        - navigate().to() is like method of get() with functionality but navigate().to() can take both string format or URL object format from URL class
        but get() method only take string format
        - when use navigate().to() method it actually calls and pass url to get method


        2-navigate().back : go back

        3-navigate().forward() : go foreword

        4-navigate().refresh() : refresh browser

         */

public class NavigationalMethods {
    public static void main(String[]args) throws MalformedURLException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://demo.nopcommerce.com/");

        //1-navigate().to
        //can take both string or object from URL class
        driver.get("https://demo.nopcommerce.com/");  // string

        driver.navigate().to("https://demo.nopcommerce.com/");
        URL myUrl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");   // object from URL class
        driver.navigate().to(myUrl);

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();



    }
}
