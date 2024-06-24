package day_30;

/*
frames: is separate webpage inside webpage so can not locate element in frames till first access on it,
and you should exist from to interact with parent page
frames in DOM html have tags like Frame - Iframe - form
to access to frames we have 4 ways (same methods with different parameters (overloading) )
1-driver.switchTo().frame(id)
2-driver.switchTo().frame("name")
3-driver.switchTo().frame(WebElement)
4-driver.switchTo().frame(index)

 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Frames {
    public static void main(String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");

        // frame 1
        WebElement Frame1 =driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(Frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

        // frame2
        // first before access to frame2 you should exist from frame1 to parent page by driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();  // go back to parent page

        WebElement Frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(Frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

        // frame3
        driver.switchTo().defaultContent();  // go back to parent page

        WebElement Frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(Frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");


        // access to Iframe that inside Frame3
        //you not need to go back parent page as iframe part of frame3

        // if only frame inside parent frame you can use indexing to access it
        driver.switchTo().frame(0);

        // as each frame is separate page you can open its link and locate element inside them easily
        // like open link of iframe : "https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true"
        driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();

        // note if any element can not interact with normal way we can use this way (JavascriptExecutor)
        WebElement checkBox=driver.findElement(By.xpath("//div[@id='i19']//div[@class='uHMk6b fsHoPb']"));
        JavascriptExecutor Js =(JavascriptExecutor)driver;
        Js.executeScript("arguments[0].click();",checkBox);

        //note as you want to exist from Iframe to parent page you not need to go back to frame3 then go back again to parent page
        // just go back single command will access to parent page

        driver.switchTo().defaultContent();  // go back to parent page
        //frame4
        WebElement Frame4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(Frame4);
        driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Python");

        //assessment
        driver.switchTo().defaultContent();  // go back to parent page

        WebElement Frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(Frame5);
        driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loo= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));

        Boolean logoD =loo.isDisplayed();
        System.out.println("logo is present " + logoD);



    }
}
