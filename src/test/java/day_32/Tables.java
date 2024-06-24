package day_32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    there are 3 type of table to handel
    1-static table
    2-dynamic table
    3-pagination table

    1- static table : table with static data (rows and columns)
    - refer in Dom by tag  tbody  >> under it there is 3 kind of tags
    1-tr >> refer to rows   (number of rows)
    2-th >> refer to header (number of columns)
    3-td >> refer to data in rows
 */
public class Tables {
    public static void main (String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
//        // Static table
//        //1-find total number of rows in table
//        List<WebElement> table =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
//        System.out.println("number of rows "+ table.size());
//
//        int numberRows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
//        System.out.println("number of rows "+ numberRows);
//
//        int numRowsTables= driver.findElements(By.tagName("tr")).size();  // tag tr >> get all tables in the page
//        System.out.println("number of rows "+ numRowsTables);
//
//        //2-find total number of rows in table
//        List<WebElement> tableColumns =driver.findElements(By.xpath("//table[@name='BookTable']//tr//th"));
//        System.out.println("number of Columns "+ tableColumns.size());
//
//        int numberColumns= driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
//        System.out.println("number of Columns "+ numberColumns);
//
//        int numColumnsTables= driver.findElements(By.tagName("th")).size();  // tag th >> get all tables in the page
//        System.out.println("number of Columns "+ numColumnsTables);
//
//        //3-Read data from specific row and column (ex : 5th rows and 1st column)
//        String bookName1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
//        System.out.println(bookName1);       //Master In Selenium
//
//        String bookName2 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[3]")).getText();
//        System.out.println(bookName2);       //Javascript
//
//        //4-Read data from all rows and columns
//        //note : to pass variables in xpath >> "+variableName+"  ex "+r+"
//
//        for(int r = 2; r<=numberRows; r++)
//        {
//            for (int c = 1; c<=numberColumns; c++)
//            {
//                String values = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//                System.out.print(values+ "    ");
//            }
//            System.out.println();
//        }
//
//
//        // print specific value by identify other value in the table
//        //ex: print all names of the book whose author Amit
//        for(int r=2;r<=numberRows;r++) {
//            String Author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
//
//            if (Author.equals("Amit") || Author.equals("Mukesh")) {
//                String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
//                System.out.println(BookName + "\t" + Author);
//
//                //note 	"\t" >> press tab space	between to item like "  "
//
//            }
//        }
//
//
//            // if you want total price of all books
//            int total =0;
//            for(int r=2;r<=numberRows;r++)
//            {
//                String prices = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
//                int price = Integer.parseInt(prices);    // converting String >> integer
//                total =total+price;
//            }
//            System.out.println("total price of all books "+ total);
//
//
//            //assessment
//        driver.get("https://blazedemo.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement cityDD = driver.findElement(By.xpath("//select[@name='fromPort']"));
//        Select city = new Select(cityDD);
//        city.selectByVisibleText("San Diego");
//        WebElement destinationDD = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select destination = new Select(destinationDD);
//        destination.selectByVisibleText("Cairo");
//        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        WebElement flightsTable= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']")));
//
//        int rowNum = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
//        int colNum = driver.findElements(By.xpath("//table[@class='table']//th")).size();
//
//        ArrayList priceList = new ArrayList();
//
//        for(int r =1; r<rowNum;r++) {
//            String Price = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]")).getText();
//
//            System.out.println(Price);
//            priceList.add(Price);
//        }
//
//        System.out.println(priceList);
//        Collections.sort(priceList);
//        System.out.println(priceList);
//
//        for(int r = 2 ; r<rowNum;r++)
//        {
//
//            if(driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText().equals(priceList.get(0)))
//            {
//
//                driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td//input[@type='submit']")).click();
//                break;
//            }
//
//        }
//
//        WebElement purchaseFlight =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Purchase Flight']")));
//        purchaseFlight.click();
//
//        driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText().equals("Thank you for your purchase today!");



        //2-pagination table

       driver.get("https://testautomationpractice.blogspot.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        List<WebElement> Pages =driver.findElements(By.xpath("//ul[@id='pagination']//li"));
        int totalPages = Pages.size();
        System.out.println(totalPages);

        List<WebElement> totalRow = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
        List<WebElement> totalCol = driver.findElements(By.xpath("//table[@id='productTable']//tr//th"));

        ArrayList prices = new ArrayList();


        for(int p = 1 ; p<=totalPages;p++)
        {
            if (p>1)
            {
                driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]")).click();
            }
            for (int r=1;r<=totalRow.size();r++)
            {
                String productPrice =driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
                prices.add(productPrice);
            }

            System.out.println(prices);
            Collections.sort(prices);
            System.out.println(prices);


            for (int r=1;r<=totalRow.size();r++)
            {

                if(driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[3]")).getText().equals(prices.get(0)))
                {
                    driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[4]//input[@type='checkbox']")).click();
                    String productName =driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[2]")).getText();
                    String price = driver.findElement(By.xpath("//table[@id='productTable']//tr["+r+"]//td[3]")).getText();
                    System.out.println(productName + "  " +price);



                }


            }
            prices.clear();
        }





    }


}

