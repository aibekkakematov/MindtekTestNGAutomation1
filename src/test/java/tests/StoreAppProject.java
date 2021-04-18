package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.DataUtils;
import utilities.TestBase;

public class StoreAppProject extends TestBase {

    @Test //validate if discounted items are calculated correctly.
    public void test01(){
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();

        driver.get(Configuration.getProperty("StoreURL"));
        for(int i=0; i<storeAppHomePage.discountPrice.size();i++){
            double priceWithDiscount = Double.parseDouble(storeAppHomePage.discountPrice.get(i).getText()
                    .replaceAll("\\$", ""));
            double priceWithoutDiscount = Double.parseDouble(storeAppHomePage.priceWithoutDiscount.get(i).getText()
                    .replaceAll("\\$",""));
            double discount = Double.parseDouble(storeAppHomePage.discount.get(i).getText()
                    .replaceAll("\\%",""));
            double actualPriceWithDiscount = priceWithoutDiscount+priceWithoutDiscount*discount/100;
            double roundedPrice = (double)Math.round(actualPriceWithDiscount*100)/100;

            Assert.assertEquals(roundedPrice, priceWithDiscount,
                    "Actual price with discount "+actualPriceWithDiscount+" doesn't match with expected: "+priceWithDiscount+"!");

        }
    }

    @DataProvider(name = "customerServiceTestData")
    public static Object[][]testData(){
        return new Object[][]{
                {"2", DataUtils.getRandomEmail(), "Hello!" },
                {"2"," ","Hello!"}
        };
    }

    @Test(dataProvider = "customerServiceTestData")
    public void test02(String subjectHeading, String email, String message) {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();

        driver.get(Configuration.getProperty("StoreURL"));
        storeAppHomePage.contactUsButton.click();

        BrowserUtils.selectDropdownByValue(storeAppContactUsPage.subjectHeading, subjectHeading);
        storeAppContactUsPage.emailAddress.sendKeys(email);
        storeAppContactUsPage.message.sendKeys(message);
        storeAppContactUsPage.sendButton.click();







        
        String successMessage = "Your message has been successfully sent to ";


    }
}
