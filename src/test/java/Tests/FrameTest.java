package Tests;

import HelperMethods.AlertMethod;
import HelperMethods.ElementMethod;
import HelperMethods.FrameMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

    public WebDriver driver;

    @Test

    public void FrameTest(){
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

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/submeniul

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMeniu.click();
        elementMethod.clickElement(alertMeniu);

        WebElement frameOptionMeniu = driver.findElement(By.xpath("//span[text()='Frames']"));
        //alertsoptionMeniu.click();
        elementMethod.clickElement(frameOptionMeniu);

        //ne mutam cu focusul pe un iframte
        //driver.switchTo().frame("frame1");
        frameMethod.switchtoFrame("frame1");

        WebElement iFrameText = driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText.getText());

        //ne intoarcem cu focusul la frame-ul default
        //driver.switchTo().defaultContent();
        frameMethod.defaultFrame();

        //driver.switchTo().frame("frame2");
        frameMethod.switchtoFrame("frame2");

        WebElement iFrameText2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText2.getText());

        //ne intoarcem cu focusul la frame-ul default
        //driver.switchTo().defaultContent();
        frameMethod.defaultFrame();

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
