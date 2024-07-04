package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethod {
//Constructor
    public WebDriver driver;

    public WindowMethod(WebDriver driver) {
        this.driver = driver;
    }

    //metode generale pentru interactiunea cu tab/window

    public void switchSpecificTab (Integer index) {

        List<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(index));//interactionam cu un tab/window - ne va arata url-ul paginii

    }

    public void closeCurrentTab(){
        driver.close();
    }
}
