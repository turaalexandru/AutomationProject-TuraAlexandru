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

public class NestedFramePage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;
    public WindowMethod windowMethod;
    public FrameMethod frameMethod;

    public NestedFramePage (WebDriver driver) {
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        windowMethod = new WindowMethod(driver);
        frameMethod = new FrameMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;

    @FindBy (xpath = "//p")
    public WebElement text;

public void interactWithChildFrame (){
    //interactionam cu iframe in iframe
    frameMethod.switchtoFrame("frame1");
    frameMethod.switchtoFrameWE(childFrame);
    System.out.println(text.getText());
}

}
