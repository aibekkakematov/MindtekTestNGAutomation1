package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlazeDemoHomePage;
import utilities.TestBase;



public class BlazeDemoTest extends TestBase {


    @Test
    public void test(){
        BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage();
        driver.get("https://blazedemo.com/index.php");
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        blazeDemoHomePage.findFlightsButton.click();
        String expectedTitle = "BlazeDemo - reserve";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
