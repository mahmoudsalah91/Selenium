package day_35;
        /*
        to press any button in keyboard use Actions class
        keydown button > keyup button

        note to press on any characters use sendKeys ("") > ex sendKeys("A")
         */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class KeyboardActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
        //1- create object from Actions Class
        Actions action = new Actions(driver);

        //Ctrl + A
        //keydown button > keyup button
        action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //Ctrl + C
        action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        // Tab
        action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //Ctrl + V
        action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
    }
}
