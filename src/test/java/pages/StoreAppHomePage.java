package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class StoreAppHomePage {
    WebDriver driver;

    public StoreAppHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//ul[@id='homefeatured']//div[@class='right-block']//span[contains(@class,'price-percent-reduction')]/preceding-sibling::*[@class=\"price product-price\"]")
    public List<WebElement> discountPrice;
    @FindBy(xpath = "//ul[@id='homefeatured']//div[@class='right-block']//span[contains(@class,'price-percent-reduction')]/preceding-sibling::*[@class=\"old-price product-price\"]")
    public List<WebElement> priceWithoutDiscount;
    @FindBy(xpath = "//ul[@id='homefeatured']//div[@class='right-block']//span[contains(@class,'price-percent-reduction')]")
    public List<WebElement> discount;
    @FindBy(xpath="//a[@title='Contact Us']")
    public WebElement contactUsButton;

}
