package day_31;

/*
 There are 3 type of dropdown
    1- Select dropdown     >> use when Select tag find in DOM
    if there is no Select tag in DOM use
    2- Bootstrap dropdown
    3- hidden dropdown

    1- Select dropdown     >> use when Select tag find in DOM
    to select element inside Select dropdown
    1-select element and declare it in WebElement
    2-create object from  Select class pass this element inside it
    3-use this object to select element in dropdown 3 method
    selectByVisibleText();  --- selectByValue(); --- selectByIndex();

   >> if there is no Select tag in DOM use
    2- Bootstrap dropdown : dropdown contain checkboxes can check single or multi options

    3-hidden dropdown :that elements inside dropdown is always hidden
    can handel this by freeze the DOM  by debugger option in SelectorHub tool
    OR
    After click inspect on element >> remove blur option from Event Listeners


 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {
    public static void main (String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //1)- Select dropdown
        WebElement countryDDElement = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDD = new Select(countryDDElement);
        countryDD.selectByVisibleText("Canada");
        countryDD.selectByValue("uk");
        countryDD.selectByIndex(6);

        // to capture the count of option in dropdown list

         List<WebElement>options = countryDD.getOptions();
        System.out.println("number of option in dropdown list:"+options.size());

        // to print the options in dropdown list

        //1-use normal for loop
        for(int i =0;i<options.size();i++)
        {
            System.out.println(options.get(i).getText());
        }

        //2-use enhanced for loop
        for (WebElement option :options)
        {
            System.out.println(option.getText());
        }

        //2)- Bootstrap dropdown : dropdown contain checkboxes can check single or multi options

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");


        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();   // open dropdown list

        //1-for check single option
        driver.findElement(By.xpath("//input[@value='Java']")).click();

        //2-for multi options
        List <WebElement> listOptions = driver.findElements(By.xpath("//ul//label"));
        for (WebElement OP:listOptions)
        {
           String optionName = OP.getText();
            if (optionName.equals("Python") || (optionName.equals("Databases")) || (optionName.equals("Oracle")))
            {
                OP.click();
            }

        }

        //3)-hidden dropdown :that elements inside dropdown is always hidden

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();




        //Select single option
        //driver.findElement(By.xpath("//span[normalize-space()='Automaton Tester']")).click();

        // Count number of option in dropdown
       List<WebElement> Options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println(Options.size());

        // print all elements in dropdown
        for (WebElement OP:Options)
        {
            System.out.println(OP.getText());
        }


        //4)Handel Auto suggestions drop down

        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
        List <WebElement> suggestionsResult = driver.findElements(By.xpath("//div[@class='wM6W7d' and @role='presentation']"));
        Thread.sleep(5000);
        System.out.println(suggestionsResult.size());


        for(WebElement suggestionsResults : suggestionsResult)
        {
            System.out.println(suggestionsResults.getText());
            if(suggestionsResults.getText().equals("selenium webdriver"))
            {
                suggestionsResults.click();
                break;
            }

        }

        //assessment

        driver.get("https://phppot.com/demo/react-select-box/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement countryDropD = driver.findElement(By.xpath("//select[1]"));

        Thread.sleep(5000);
        Select country = new Select(countryDropD);
        country.selectByVisibleText("United Kingdom");

        List<WebElement> Country = driver.findElements(By.xpath("//select[1]//option"));

        System.out.println(Country.size());
        for (WebElement op : Country)
        {
            System.out.println(op.getText());
            if(op.getText().equals("Canada"))
            {
                op.click();
            }
        }


    }
}
