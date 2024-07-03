package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethod {

    public WebDriver driver;

    //Constructor
    public FrameMethod (WebDriver driver) {
        this.driver = driver;
    }

    public void switchtoFrame (String text) {
        driver.switchTo().frame(text);
    }

    public void switchtoFrameWE (WebElement element) {
        driver.switchTo().frame(element);
    }

    public void defaultFrame (){
        driver.switchTo().defaultContent();
    }

}
