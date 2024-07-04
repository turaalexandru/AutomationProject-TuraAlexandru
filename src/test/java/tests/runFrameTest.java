package tests;

import helperMethods.AlertMethod;
import helperMethods.ElementMethod;
import helperMethods.FrameMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;

import java.time.Duration;

public class runFrameTest {

    public WebDriver driver;

    @Test

    public void FrameTest() {
        //Deschidem un browser
        driver = new ChromeDriver();

        //deschidem un anumit URL
        driver.get("https://demoqa.com");

        //Facem browserul in mod maximize

        driver.manage().window().maximize();

        //definim un obiect de tip alert methods ca sa apelam metodele din clasa
        AlertMethod alertMethod = new AlertMethod(driver);

        //wait implicit - va astepta reactia din partea driverului
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
