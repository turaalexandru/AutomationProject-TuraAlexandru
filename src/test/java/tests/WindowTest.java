package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertWindowsPage;
import pages.HomePage;
import pages.WindowPages;

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

        //definim un obiect de tipul homepage

        HomePage hopePage = new HomePage(driver);
        hopePage.navigateToAlertMenu();

        //definim un obiect de tipul aletwindow

        AlertWindowsPage alertWindows = new AlertWindowsPage(driver);
        alertWindows.navigateToWindowPage();


        //interactionam cu un newtabButton
        WindowPages windowPages = new WindowPages(driver);
        windowPages.interactWithNewTabButton();
        //interactionam cu un newwindowButton
        windowPages.interactWithNewWindowButton();

        //inchidem browserul
        driver.quit();

    }
}
