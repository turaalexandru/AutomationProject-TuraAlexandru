package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import helperMethods.WindowMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WindowPages {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public WindowMethod windowMethod;

    public WindowPages (WebDriver driver) {
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        windowMethod = new WindowMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    public void interactWithNewTabButton () {
        pageMethods.scrollPage(0, 150);
        elementMethod.clickElement(newTabButton);
        System.out.println(driver.getCurrentUrl()); //url-ul paginii
        //gaseste cate tab-uri sunt deschise in timpul definirii
        Set<String> allWindowHandles = driver.getWindowHandles();
        //Ne mutam cu focusul pe unul dintre tab-uri
        windowMethod.switchSpecificTab(1);
        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii
        //inchidem driverul current
        windowMethod.closeCurrentTab();
        //Ne mutam cu focusul pe unul dintre tab-uri
        windowMethod.switchSpecificTab(0);

    }

    public void interactWithNewWindowButton () {
        elementMethod.clickElement(newWindowButton);
        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii
        //gaseste cate tab-uri sunt deschise in timpul definirii
        Set<String> newWindowHandles = driver.getWindowHandles();
        //Ne mutam cu focusul pe unul dintre tab-uri
        windowMethod.switchSpecificTab(1);
        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii
        //inchidem driverul current
        windowMethod.closeCurrentTab();
    }
}
