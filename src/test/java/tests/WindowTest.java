package Tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void AlertTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //deschidem un anumit URL
        driver.get("https://demoqa.com");

        //Facem browserul in mod maximize

        driver.manage().window().maximize();

        //definim un obiect de tipul window method
        WindowMethod windowMethod = new WindowMethod(driver);

        //definim un obiect de tipul element method

        ElementMethod elementMethod = new ElementMethod(driver);

        //definim un obiect de tipul page method

        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/submeniul

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMeniu.click();
        elementMethod.clickElement(alertMeniu);

        WebElement browsersoptionMeniu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browsersoptionMeniu.click();
        elementMethod.clickElement(browsersoptionMeniu);

        //interactionam cu un newtabButton
        WebElement newtabButton = driver.findElement(By.id("tabButton"));
        //newtabButton.click();
        elementMethod.clickElement(newtabButton);

        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii

        //gaseste cate tab-uri sunt deschise in timpul definirii
        Set<String> allWindowHandles = driver.getWindowHandles();
        //List<String> tabs = new ArrayList<>(allWindowHandles);

        //Ne mutam cu focusul pe unul dintre tab-uri
        //driver.switchTo().window(tabs.get(1));
        //windowMethod
        windowMethod.switchSpecificTab(1);

        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii

        //inchidem driverul current
        //driver.close();
        windowMethod.closeCurrentTab();
        //driver.switchTo().window(tabs.get(0));

        //interactionam cu un newwindowButton
        WebElement newwindowButton = driver.findElement(By.id("windowButton"));
        //newwindowButton.click();
        elementMethod.clickElement(newwindowButton);

        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii

        //gaseste cate tab-uri sunt deschise in timpul definirii
        Set<String> newWindowHandles = driver.getWindowHandles();
        //List<String> window = new ArrayList<>(newWindowHandles);

        //Ne mutam cu focusul pe unul dintre tab-uri
        //driver.switchTo().window(window.get(1));

        windowMethod.switchSpecificTab(1);
        //interactionam cu un tab/window - ne va arata url-ul paginii
        System.out.println(driver.getCurrentUrl()); //url-ul paginii

        //inchidem driverul current
        //driver.close();
        windowMethod.closeCurrentTab();
        //driver.switchTo().window(window.get(0));

        //inchidem browserul
        driver.quit();

    }
}
