package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertMeniu;

    @FindBy(xpath = "//h5[text()='Forms']")
    public  WebElement formMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    public  WebElement elementsMeniu;


    public void navigateToAlertMenu () {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(alertMeniu);
    }

    public void navigateToFormMenu() {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(formMenu);
    }

    public void navigateToElementsMenu() {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(elementsMeniu);
    }
}
