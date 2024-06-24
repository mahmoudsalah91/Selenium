package day_26;

        /*
        Conditional Methods : access these methods through webElement
        return boolean value (true / false)
        1-isDisplayed
        2-isEnabled
        3-isSelected
         */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[]args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement Logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("logo is displayed "+ Logo.isDisplayed());

        //or
        boolean Logo1 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println("logo is displayed "+ Logo1);



        boolean Search = driver.findElement(By.xpath("//input[@id='small-searchterms']")).isEnabled();
        System.out.println("search is enabled "+ Search);


        WebElement ExcellentPollRate =driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        System.out.println("Excellent is selected "+ExcellentPollRate.isSelected());

        ExcellentPollRate.click();
        System.out.println("Excellent is selected "+ExcellentPollRate.isSelected());



    }
}
