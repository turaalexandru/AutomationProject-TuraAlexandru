package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{


    public FramePage (WebDriver driver) {
        super(driver);
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
