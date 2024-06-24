package day_33;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
    to handel date in calendar (date piker) by 2 methods

    1- normal method
    by use sendKeys in text filed of date

    2- select with calendar
 */

public class DateCalendar {

    public static void main (String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(0);    // Access frame

        // 1- normal method (sendKeys)

       // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("07/12/2024");

        // 2- select with calendar
        //open calendar
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        //1- declaration witch expected data pass in calendar
        String expectedMonth = "September";
        String expectedYear =  "2025";
        String expectedDay  =  "15";

        // 2- select  month and year



        while (true)
        {
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear))
            {
                break;
            }
            driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
        }

        // select day
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day : days)
        {
            if(day.getText().equals(expectedDay))
            {
                day.click();
                break;
            }
        }

        // can make as method to use it many times in all class


        //open calendar


        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        Thread.sleep(5000);

        String Month = "November";
        String Year =  "2026";
        String Day  =  "10";

        SelectFutureDate(driver,Month,Year,Day);





    }

    static void SelectFutureDate(WebDriver driver ,String Month , String Year , String Day)
    {
    
        while (true)
        {
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(currentMonth.equals(Month) && currentYear.equals(Year))
            {
                break;
            }
            driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
        }

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement day : days)
        {
            if(day.getText().equals(Day))
            {
                day.click();
                break;
            }
        }

    }






}
