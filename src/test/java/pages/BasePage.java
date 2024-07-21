package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public AlertMethod alertMethod;
    public ElementMethod elementMethod;
    public FrameMethod frameMethod;
    public PageMethods pageMethods;
    public WindowMethod windowMethod;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        alertMethod = new AlertMethod(driver);
        elementMethod = new ElementMethod(driver);
        frameMethod = new FrameMethod(driver);
        pageMethods = new PageMethods(driver);
        windowMethod = new WindowMethod(driver);
        PageFactory.initElements(driver, this);
    }
}
