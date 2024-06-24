package day_28;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(5000);
        Set<String> Windows = driver.getWindowHandles();
        System.out.println(Windows);

        //Approach 1 use Array list >>> use for just 2 windows
        // convert set collection to Array list that contain get method with indexing
        List<String> winID = new ArrayList<>(Windows);

        String parentID = winID.get(0);
        String childID = winID.get(1);

        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());

//        //Approach 2 use For loop  >>> >>> use for more than 2 windows
//        for (String windowsIDs : Windows) {
//            String title = driver.switchTo().window(windowsIDs).getTitle();
//            if (title.equals("OrangeHRM")) {
//                String parentUrl = driver.getCurrentUrl();
//                driver.switchTo().window(parentUrl);
//
//
//            }
//        }
//
//            // practice to close specific browser window
//
//            for (String windowIDS : Windows) {
//                String specificTitle = driver.switchTo().window(windowIDS).getTitle();
//                System.out.println(specificTitle);
//                if (specificTitle.equals("OrangeHRM")) {
//                    driver.close();
//                }
//
//            }
//

            // assessment search - count of links - click on each link - get windows Ids - close specific browser window

            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).click();
            driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("Selenium");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(5000);
            List<WebElement> linkCount = driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
            System.out.println("link Count is " + linkCount.size());


            for (WebElement links : linkCount) {
                links.click();

            }
            Thread.sleep(5000);

            Set<String> windowsIds = driver.getWindowHandles();
            System.out.println(windowsIds);

            for (String windows : windowsIds) {
                String titles = driver.switchTo().window(windows).getTitle();
                System.out.println(titles);
                if (titles.equals("Selenium - Wikipedia") || titles.equals("Selenium dioxide - Wikipedia")) {
                    driver.close();
                }
            }


        }
    }



