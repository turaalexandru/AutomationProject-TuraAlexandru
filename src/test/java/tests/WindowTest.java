package tests;

import org.testng.annotations.Test;
import pages.AlertWindowsPage;
import pages.HomePage;
import pages.WindowPages;
import sharedData.SharedData;

public class WindowTest extends SharedData {


    @Test
    public void AlertTest() {


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
