package day_34;

/*
    Mouse Actions
    -------------
    hover         -- moveToElement(WebElement)
    right click   -- contextClick(WebElement)
    double click  -- doubleClick(WebElement)
    drag and drop -- dragAndDrop(sourceElement,TargetElement)
    move slider bar -- dragAndDrop(sourceElement,x-axis,y-axis)

    can perform mouse actions by use predefined class provided by selenium called Actions
    note: every statement use object from Actions class end by build() and perform() or perform() only

   build():create an action
   perform():complete an action and also build can use only without build

note:
   difference between Actions and Action
   Actions is class use to perform mouse actions
   Action  is interface use to store created actions


 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseActions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        WebElement Notebooks = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']"));
        Actions action = new Actions(driver);

        //1- hover

        //action.moveToElement(Computer).moveToElement(Notebooks).click().build().perform(); // with build()
        // same without build
        action.moveToElement(Computer).moveToElement(Notebooks).click().perform();   // without build ()

        // 2- right click

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        action.contextClick(rightClick).perform();

        //click on copy
        driver.findElement(By.xpath("//span[text()='Copy']")).click();

        // Accept alert
        driver.switchTo().alert().accept();

        // 3- Double click

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement copyText = driver.findElement(By.xpath("//button[text()='Copy Text']"));
        action.doubleClick(copyText).perform();

        // 4- drag and drop

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement madridBox = driver.findElement(By.xpath("//div[@id='box7']"));
        WebElement spainBox = driver.findElement(By.xpath("//div[@id='box107']"));
        
        action.dragAndDrop(madridBox,spainBox).perform();


        //note: can store the action created in variable called Action then perform it later
        /*
        difference between Actions and Action
        Actions is class use to perform mouse actions
        Action  is interface use to store created actions
         */
        WebElement romeBox = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement italyBox = driver.findElement(By.xpath("//div[@id='box106']"));

       Action myAction = action.dragAndDrop(romeBox,italyBox).build();
       myAction.perform();


       //assessment

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement bankHolder = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
        WebElement bankValue = driver.findElement(By.xpath("//a[normalize-space()='5000']"));
        WebElement bankValueHolder = driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));

        action.dragAndDrop(bank,bankHolder).perform();
        action.dragAndDrop(bankValue,bankValueHolder).perform();


        //move slider bar -- dragAndDrop(sourceElement,x-axis,y-axis)
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        WebElement startPointSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
        System.out.println(startPointSlider.getLocation());

        action.dragAndDropBy(startPointSlider,100,250).perform();
        System.out.println(startPointSlider.getLocation());

        WebElement endPointSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
        System.out.println(endPointSlider.getLocation());

        action.dragAndDropBy(endPointSlider,-50,250).perform();
        System.out.println(endPointSlider.getLocation());



    }
}
