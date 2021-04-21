package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

import java.io.IOException;
import java.util.List;

public class SauceDemoProblemUserTest extends TestBase {

@Test(groups = {"smoke"})
@Parameters({"username","password"})
    public void test1(String username, String password) throws IOException {
    driver.get(Configuration.getProperty("SauceDemoURL"));
    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    sauceDemoLoginPage.username.sendKeys(username);
    sauceDemoLoginPage.password.sendKeys(password);
    sauceDemoLoginPage.loginButton.click();
    SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
    BrowserUtils.selectDropdownByValue(sauceDemoHomePage.filterDropdown, "lohi");
    BrowserUtils.takeScreenshot("FilteredDropdown");
    BrowserUtils.scroll(250);
    BrowserUtils.takeScreenshot("FilteredDropdown2");

    List<WebElement> prices = sauceDemoHomePage.prices;
    for (int i=0; i< prices.size(); i++){
        double price1 = Double.parseDouble(prices.get(i).getText().substring(1));
        double price2 = Double.parseDouble(prices.get(i+1).getText().substring(1));
        Assert.assertTrue(price2>=price1);
    }

}

@Test
    public void test2(){
    System.out.println(System.getProperty("user.dir"));
}
}
