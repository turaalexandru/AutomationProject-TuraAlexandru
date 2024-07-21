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
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (index >= 0 && index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + tabs.size());
    }

    }

    public void closeCurrentTab(){
        driver.close();
    }
}
