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

import java.time.Duration;

public class FrameTest {

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

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/submeniul
        homePage.navigateToAlertMenu();

        AlertWindowsPage alertWindowsPage = new AlertWindowsPage(driver);
        alertWindowsPage.navigateToFrameOptionMeniu();

        //ne mutam cu focusul pe un iframte
        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigIFrame();
        framePage.interactWithSmallIFrame();

        WebElement nestedoptionMeniu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        //alertsoptionMeniu.click();
        elementMethod.clickElement(nestedoptionMeniu);

        //interactionam cu iframe in iframe

        //driver.switchTo().frame("frame1");
        frameMethod.switchtoFrame("frame1");

        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>]/"));
        //driver.switchTo().frame(childFrame);
        frameMethod.switchtoFrameWE(childFrame);

        WebElement text = driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());

    }

}
