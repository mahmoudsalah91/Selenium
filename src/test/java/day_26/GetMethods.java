package day_26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/*
            GetMethods : we can access these methods through webdriver instance
            ----------
            1-get(url) : open url in browser
            2-getTitle() : return url of the page
            3-getCurrentUrl() : return Current Url of the page
            4-getPageSource() : return Page Source Url of the page
            5-getWindowHandle() : return ID of single Browser window
            6-getWindowHandles() : return ID's  of multiple Browser windows

        */
public class GetMethods {
    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String title =driver.getTitle();
        System.out.println(title);

        String currentUrl =driver.getCurrentUrl();
        System.out.println(currentUrl);

        String PageSource =driver.getPageSource();
        System.out.println(PageSource);

        String WindowHandle =driver.getWindowHandle();
        System.out.println(WindowHandle);


        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> WindowHandles = driver.getWindowHandles();
        System.out.println(WindowHandles);


    }
}
