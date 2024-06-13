package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethod {

    public WebDriver driver;

    //Constructor
    public AlertMethod(WebDriver driver) {
        this.driver = driver;
    }

    //definim metode generale pentru interactiune cu alerte
    public void waitforAlert (){
        WebDriverWait alertDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    // Acceptă alerta
    public void acceptAlert (){
        waitforAlert();
        Alert alertButton = driver.switchTo().alert();
        System.out.println(alertButton.getText());
        alertButton.accept();
    }
    // Respinge alerta
    public void dismissAlert (){
        waitforAlert();
        Alert alertconfirmButton = driver.switchTo().alert();
        System.out.println(alertconfirmButton.getText());
        alertconfirmButton.dismiss();
    }
    // Completează textul în alertă și o acceptă
    public void fillAlert (String nume) {
        Alert alertwaitButton = driver.switchTo().alert();
        System.out.println(alertwaitButton.getText());// Afișează textul alertei în consolă
        alertwaitButton.sendKeys(nume);
        alertwaitButton.accept();
    }
}
