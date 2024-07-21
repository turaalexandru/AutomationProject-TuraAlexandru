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

public class WindowPages extends BasePage {

    public WindowPages(WebDriver driver) {
        super(driver);
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
        if (allWindowHandles.size() > 1) {
            windowMethod.switchSpecificTab(1);
            System.out.println("Current URL after switching to new tab: " + driver.getCurrentUrl());
            windowMethod.closeCurrentTab();
            windowMethod.switchSpecificTab(0);
        }

    }

    public void interactWithNewWindowButton () {
        elementMethod.clickElement(newWindowButton);
        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii
        //gaseste cate tab-uri sunt deschise in timpul definirii
        Set<String> newWindowHandles = driver.getWindowHandles();

        if (newWindowHandles.size() > 1) {
            windowMethod.switchSpecificTab(1);
            System.out.println("Current URL after switching to new window: " + driver.getCurrentUrl());
            windowMethod.closeCurrentTab();
        }
    }
}
