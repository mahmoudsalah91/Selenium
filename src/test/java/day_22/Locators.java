package day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators {

    public static void main(String[]args){

        WebDriver driver = new ChromeDriver();

//        driver.get("https://demo.opencart.com/");
//
//        driver.manage().window().maximize();    //maximize window
//
//        // 1- typical locators
//
//        // name
//        driver.findElement(By.name("search")).sendKeys("Mac");
//
//        //ID
//       boolean LogIsDisplayed = driver.findElement(By.id("logo")).isDisplayed();
//        System.out.println(LogIsDisplayed);
//
//        // linkText
//        driver.findElement(By.linkText("Tablets")).click();
//
//        //partialLinkText  not prefer use than linkText because could be not unique
//        //driver.findElement(By.partialLinkText("MP3")).click();
//
//        // when we want to capture group of elements use locators
//        // 1- class , 2-tag  because they are a common for multi element in a page
//
//       List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
//        System.out.println(headerLinks.size());
//
//        List<WebElement> Links = driver.findElements(By.tagName("a"));
//        System.out.println(Links.size());
//
//        List<WebElement> Images = driver.findElements(By.tagName("img"));
//        System.out.println(Images.size());
//
//
//        // assessment
//
//        driver.get("https://demoblaze.com/");
//
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//
//        List<WebElement> numberOfImages = driver.findElements(By.tagName("img"));
//        System.out.println(numberOfImages.size());
//
//        driver.findElement(By.linkText("Cart")).click();
//
//        driver.findElement(By.partialLinkText("Log")).click();
//
//        driver.quit();
//
//        /*
//        2- customize locators
//
//         1-cssSelector : cascading send sheet
//        there are 4 type of combinations to write Css
//        1-tag+id                    >> tag#id value
//        2-tag+className             >> tag.className value
//        3-tag+attribute             >> tag[attribute="value"]
//        4-tag+className+attribute   >> tag.className[attribute="value"]
//        // Note: tag is optional can write cssSelector without tags
//        */
//
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//
//        // 1-tag+id                    >> tag#id value
//        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirt");
//        // Note: tag is optional can write cssSelector without tags
//        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirt");
//
//        //2-tag+className             >> tag.className value
//        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mobile");
//        //note if class name contain spaces you should use part before space to work well
//        // ex:class="search-box-text ui-autocomplete-input"  just use >>>  "search-box-text"
//
//        //3-tag+attribute             >> tag[attribute=value]
//        driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Computer");
//        //note: in java double cots ""  is not available inside anther double cots "" so when do that we use simple regular expression like \ before and after end of value
//        // ex : "input[placeholder=\"Search store\"]" or we can use single cots ex: "input[placeholder='Search store']"
//
//        //4-tag+className+attribute   >> tag.className[attribute="value"]
//        driver.findElement(By.cssSelector("input.search-box-text[name=\"q\"]")).sendKeys("Laptop");
//
//
//        /*
//
//        2-Xpath : address of the element
//        xpath drive from XML (extensible markup Language)
//
//        there are 2 type of Xpath
//        1-Absolute (full Xpath)
//                   : traverse from first nod in Dom till reach to exact element you want to inspect
//                   : use /
//                   : not use any attributes in his hierarchy but use just Tags
//                   : not prefer as developer change from the flow of xpath you have to make update with every change
//                   ex:/html/body/div[6]/div[1]/div[2]/div[2]/form/input  >>> lengthy
//
//       2-Relative (partial Xpath)
//                   : jump directly to exact element you want to inspect
//                   : use //
//                   : use attributes in his hierarchy
//                   : prefer as developer change from the flow of xpath you not have to make update with every change
//                   ex://*[@name="q"]   >>> small
//
//                   can write it manual or use tools like selector hub
//                   syntax : //tagName[@attribute='value']
//                           //*[@attribute='value']
//
//                   note : tag name is not optional like on css selector
//        */
//
//        driver.get("https://demo.nopcommerce.com/");
//        driver.manage().window().maximize();
//
//        //1-Relative Xpath with single attribute
//        driver.findElement(By.xpath("//input[@placeholder='Search store']")).sendKeys("T-shirt");
//
//        //2-Relative Xpath with multiple attribute >>> is stronger than single but all attribute must be excited
//        driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search store']")).sendKeys("Laptop");
//
//        //3-Relative Xpath with 'and 'or' operators
//        //1- and >> both attribute must be excited
//        driver.findElement(By.xpath("//input[@name='q' and @placeholder='Search store']")).sendKeys("Computer");
//
//        //2- or >> at least one attribute must be excited
//        driver.findElement(By.xpath("//input[@name='s' or @placeholder='Search store']")).sendKeys("Mobile");
//
//        //4-Xpath with inner text >> text()
//        driver.findElement(By.xpath("//a[text()='Computers ']")).click();
//        // note //a[text()='Computers '] = //a[.='Computers '] >>> text() can write just .
//        //driver.findElement(By.xpath("//a[.='Computers ']")).click();
//        //note: link text could be contained inner text but inner text not should be link text
//        //ex:
//        boolean messageIsDisplay=driver.findElement(By.xpath("//*[text()='Computers']")).isDisplayed();
//        System.out.println("is message Display " + messageIsDisplay);
//
//        //5-Xpath with contains
//        driver.findElement(By.xpath("//a[contains(@title,'Home')]")).click();
//
//        //6-Xpath with starts-with
//        driver.findElement(By.xpath("//a[starts-with(text(),'Log')]")).click();
//
//        //7-chained Xpath : use if there is any attribute or inner text for the element by use parent locator that has attribute to identify that element
//        driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).click();
//
//        // note : css selector navigate from single direction (top to down) but Xpath navigate from multi direction (top>>down and down>>top ...)
//
//        //8- last and first index
//        String lastText=driver.findElement(By.xpath("(//a[contains(.,'Digital')])[last()]")).getText();
//        System.out.println(lastText);
//        String firstText=driver.findElement(By.xpath("(//a[contains(.,'Electronics ')])[1]")).getText();
//        System.out.println(firstText);


        /*

        Xpath Axis : neighbour Xpath
        self - parent - child - ancestor(grand parent) - descendant (grand child) - following(elements after) - preceding(elements before) - following-sibling(young brother) - preceding-sibling (elder brother)

         */
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        boolean news =driver.findElement(By.xpath("//strong[text()='News']//self::*")).isDisplayed();
        System.out.println("news is display "+ news);

        boolean newsFrame =driver.findElement(By.xpath("//strong[text()='News']//parent::div[@class='title']")).isDisplayed();
        System.out.println("newsFrame is display "+ newsFrame);

        boolean newsList =driver.findElement(By.xpath("//strong[text()='News']//ancestor::div[@class='news-list-homepage']")).isDisplayed();
        System.out.println("newsList is display "+ newsList);

        boolean newOnline =driver.findElement(By.xpath("//div[@class='news-items']//descendant::a[contains(.,'online')]")).isDisplayed();
        System.out.println("newOnline is display "+ newOnline);

        boolean Documentations =driver.findElement(By.xpath("//a[contains(text(),'nopCommerce')]//preceding-sibling::*")).isDisplayed();
        System.out.println("Documentations is display "+ Documentations);


        boolean Date =driver.findElement(By.xpath("//a[contains(text(),'nopCommerce')]//following-sibling::*")).isDisplayed();
        System.out.println("Date is display "+ Date);




    }
}
