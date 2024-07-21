package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage{

    public ElementsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webtableMeniu;


    public void navigateToWebtableMeniu () {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(webtableMeniu);
    }

}
