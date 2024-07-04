package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    public WebDriver driver;
    public ElementMethod elementMethods;
    public PageMethods pageMethods;

    public FormsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethod(driver);
        pageMethods  = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceForm;

    public void navigateToPracticeForm(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(practiceForm);
    }
}
