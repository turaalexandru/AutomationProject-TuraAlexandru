package tests;

import helperMethods.AlertMethod;
import helperMethods.ElementMethod;
import helperMethods.FrameMethod;
import helperMethods.PageMethods;
import org.testng.annotations.Test;
import pages.AlertWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.SharedData;

public class runFrameTest extends SharedData {


    @Test

    public void FrameTest() {


        //definim un obiect de tip alert methods ca sa apelam metodele din clasa
        AlertMethod alertMethod = new AlertMethod(driver);


        //definim un obiect de tip alert methods ca sa apelam metodele din clasa
        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethod frameMethod = new FrameMethod(driver);
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertMenu();

        AlertWindowsPage alertWindowsPage = new AlertWindowsPage(driver);
        alertWindowsPage.navigateToFrameOptionMeniu();

        //ne mutam cu focusul pe un iframte
        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigIFrame();
        framePage.interactWithSmallIFrame();
        framePage.interactWithNestedOptionMeniu();

        //interactionam cu iframe in iframe
        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interactWithChildFrame();

    }

}
