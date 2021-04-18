package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

import java.util.List;

public class SauceDemoAppTest extends TestBase {

    @Test(groups = {"regression", "smoke"})
    public void filterTest(){
        driver.get(Configuration.getProperty("SauceDemoURL"));
        String expectedTitle="Swag Lab";
        String actualTitle= driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle);
        //Assert.assertEquals(actualTitle, expectedTitle);
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        sauceDemoLoginPage.username.sendKeys(Configuration.getProperty("SauceDemoUsername"));
        sauceDemoLoginPage.password.sendKeys(Configuration.getProperty("SauceDemoPassword"));
        sauceDemoLoginPage.loginButton.click();
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        BrowserUtils.selectDropdownByValue(sauceDemoHomePage.filterDropdown, "lohi");
        List<WebElement> price = sauceDemoHomePage.prices;
        for (int i=0; i< price.size()-1; i++){
            double price1 = Double.parseDouble(price.get(i).getText().substring(1));
            double price2 = Double.parseDouble(price.get(i+1).getText().substring(1));

            softAssert.assertTrue(price1<=price2);
        }
        softAssert.assertAll();
    }
}
