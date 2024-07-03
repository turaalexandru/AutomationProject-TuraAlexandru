package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindows {

        public WebDriver driver;
        public ElementMethod elementMethod;
        public PageMethods pageMethods;

        public AlertWindows (WebDriver driver) {
            this.driver = driver;
            elementMethod = new ElementMethod(driver);
            pageMethods = new PageMethods(driver);
            PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browsersoptionMeniu;

    public void navigateToWindowPage () {
        pageMethods.scrollPage(0, 100);
        elementMethod.clickElement(browsersoptionMeniu);
    }
}
