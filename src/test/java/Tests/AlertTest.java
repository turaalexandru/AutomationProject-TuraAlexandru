package Tests;

import HelperMethods.AlertMethod;
import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void AlertTest() {

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

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/submeniul

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMeniu.click();
        elementMethod.clickElement(alertMeniu);

        WebElement alertsoptionMeniu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsoptionMeniu.click();
        elementMethod.clickElement(alertsoptionMeniu);

        //interactionam cu un alertButton
        WebElement clickButton = driver.findElement(By.id("alertButton"));
        //clickButton.click();
        elementMethod.clickElement(clickButton);

        alertMethod.acceptAlert(); //apelam alerta din method

        //Alert alertButton = driver.switchTo().alert();
        //System.out.println(alertButton.getText());
        //alertButton.accept();

        //interactionam cu un confirmButton-dimiss
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        //confirmButton.click();
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(confirmButton);

        alertMethod.dismissAlert(); //apelam alerta din method

        //Alert alertconfirmButton = driver.switchTo().alert();
        //System.out.println(alertconfirmButton.getText());
        //alertconfirmButton.dismiss();

        //interactionam cu un promtButton
        WebElement promtButton = driver.findElement(By.id("promtButton"));
        //promtButton.click();
        elementMethod.clickElement(promtButton);

        alertMethod.fillAlert("Aljandro"); //apelam alerta din method

        //Alert alertpromtButton = driver.switchTo().alert();
         //System.out.println(alertpromtButton.getText());
        //String alertpromtValue = "Aljandro";
        //alertpromtButton.sendKeys(alertpromtValue);
        //alertpromtButton.accept();

        //interactionam cu o alerta cu care trebuie sa asteptam putin
        WebElement waitButton = driver.findElement(By.id("timerAlertButton"));
        //waitButton.click();
        elementMethod.clickElement(waitButton);

        alertMethod.acceptAlert(); //apelam alerta din method

        //definim un wait explicit
        //WebDriverWait alertDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //alertDriverWait.until(ExpectedConditions.alertIsPresent());

        //Alert alertwaitButton = driver.switchTo().alert();
        //System.out.println(alertwaitButton.getText());
        //alertwaitButton.dismiss();

        // Închidem driver-ul
        driver.quit();

    }
}
