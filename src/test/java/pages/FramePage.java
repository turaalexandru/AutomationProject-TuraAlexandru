package pages;

import helperMethods.ElementMethod;
import helperMethods.FrameMethod;
import helperMethods.PageMethods;
import helperMethods.WindowMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public WindowMethod windowMethod;
    public FrameMethod frameMethod;

    public FramePage (WebDriver driver) {
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        windowMethod = new WindowMethod(driver);
        frameMethod = new FrameMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "sampleHeading")
    public WebElement iFrameText;

    @FindBy (id = "sampleHeading")
    public WebElement iFrameText2;

    @FindBy (xpath = "//span[text()='Nested Frames']")
    public WebElement nestedOptionMeniu;


public void interactWithBigIFrame () {
    //ne mutam cu focusul pe un iframte
    frameMethod.switchtoFrame("frame1");
    System.out.println(iFrameText.getText());
    //ne intoarcem cu focusul la frame-ul default
    frameMethod.defaultFrame();
}

public void interactWithSmallIFrame () {
    frameMethod.switchtoFrame("frame2");
    System.out.println(iFrameText2.getText());
    frameMethod.defaultFrame();
}

public void interactWithNestedOptionMeniu(){
    pageMethods.scrollPage(0,350);
    elementMethod.clickElement(nestedOptionMeniu);
}

}
