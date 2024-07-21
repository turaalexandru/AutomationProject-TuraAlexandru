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

public class FrameTest extends SharedData {


    @Test

    public void FrameTest() {


        //definim un obiect de tip alert methods ca sa apelam metodele din clasa

        PageMethods pageMethods = new PageMethods(getDriver());
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertMenu();
        pageMethods.scrollPage(0, 350);

        AlertWindowsPage alertWindowsPage = new AlertWindowsPage(getDriver());
        alertWindowsPage.navigateToFrameOptionMeniu();

        //ne mutam cu focusul pe un iframte
        FramePage framePage = new FramePage(getDriver());
        framePage.interactWithBigIFrame();
        framePage.interactWithSmallIFrame();
        framePage.interactWithNestedOptionMeniu();

        //interactionam cu iframe in iframe
        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.interactWithChildFrame();

    }

}
