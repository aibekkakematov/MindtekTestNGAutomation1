package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazeDemoHomePage;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class BlazeDemoPriceTest extends TestBase {

    @Test(groups = {"regression", "smoke"})
    public void priceTest(){
        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();

        driver.get(Configuration.getProperty("URL"));
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomePage.findFlightsButton.click();
        //List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
        List<WebElement>prices = blazeDemoFlightsPage.prices;
        for (WebElement price : prices){
            String strPrice = price.getText().substring(1);
            double doublePrice = Double.parseDouble(strPrice);
            Assert.assertTrue(doublePrice<1000);
            System.out.println(doublePrice);
        }

        }
    @Test
    public void airlineTest(){
        driver.get(Configuration.getProperty("URL"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> airlines = driver.findElements(By.xpath("//table[@class='table']//td[3]"));
        for (WebElement airline : airlines){
            String strAirline = airline.getText();
           if (strAirline.contains("Virgin America")){
               System.out.println(strAirline);
           }
        }
    }
    @Test
    public void cityNameTest(){
        driver.get("https://blazedemo.com/index.php");
        WebElement element = driver.findElement(By.name("fromPort"));
        element.click();
        Select select = new Select(element);
        select.selectByValue("San Diego");

        WebElement element1 = driver.findElement(By.name("toPort"));
        element1.click();
        Select select1 = new Select(element1);
        select1.selectByValue("New York");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


    }


}
