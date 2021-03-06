package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazeDemoHomePage {

    // Once we create an object out of this class
    // below constructor will be called

    //initElements(driver, this); will initialize
    //all webelement variables with value

    public BlazeDemoHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    /*
    PageFactory.initElements(driver, this);
    it will find all FindBy annotations

     */

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement findFlightsButton;
}
