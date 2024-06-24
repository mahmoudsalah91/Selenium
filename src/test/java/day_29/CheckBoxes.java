package day_29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main (String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //1- to handel single check box
        driver.findElement(By.xpath("//input[@id='sunday']")).click();

        //2- to handel Multiple Check boxes

       List<WebElement> CheckBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

       // use normal for loop
        for(int i=0;i<CheckBoxes.size();i++)
        {
            CheckBoxes.get(i).click();
        }

        // use enhanced for loop

        for (WebElement checkbox:CheckBoxes)
        {
            checkbox.click();
        }

        //3-Check last 3 check boxes >> starting index = total no off check boxes - no of check box you want selected
        // starting index = 7 - 3 = 4
        for (int i = 4;i<CheckBoxes.size();i++)
        {
            CheckBoxes.get(i).click();
        }

        //4- Check First 3 check boxes
        for (int i = 0;i>3;i++)
        {
            CheckBoxes.get(i).click();
        }

        // unselect check boxes already selected
            Thread.sleep(5000);
        for (WebElement checkbox:CheckBoxes) {
            if (checkbox.isSelected())
            {
                checkbox.click();
            }
        }

        //assessment
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody//input[@type='checkbox']"));
        for (WebElement checkBoxesTable:checkBoxes)
        {
            checkBoxesTable.click();
        }




    }
}

