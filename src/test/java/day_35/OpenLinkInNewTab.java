package day_35;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenLinkInNewTab {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        //1- create object from Actions Class
        Actions action = new Actions(driver);
        WebElement RegisterLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        action.keyDown(Keys.CONTROL).click(RegisterLink).keyUp(Keys.CONTROL).perform();


        // navigate to new open tab
        //Approach  use Array list >>> use for just 2 windows
        // convert set collection to Array list that contain get method with indexing
        Set<String> Windows = driver.getWindowHandles();
        System.out.println(Windows);
        List <String> WinIDs = new ArrayList<>(Windows);

        String RegisterID = WinIDs.get(1);
        String HomeID = WinIDs.get(0);

        driver.switchTo().window(RegisterID);
        Thread.sleep(3000);
        driver.switchTo().window(HomeID);



    }
}
