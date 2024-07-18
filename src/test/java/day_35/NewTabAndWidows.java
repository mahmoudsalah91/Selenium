package day_35;

/*
  to open new tab >>  driver.switchTo().newWindow(WindowType.TAB)
  to open new window >>
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabAndWidows {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://phppot.com/");

    }
}
