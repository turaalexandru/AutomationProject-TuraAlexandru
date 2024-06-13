package Tests;

import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //Deschidem un browser
        driver = new ChromeDriver();

        //deschidem un anumit URL
        driver.get("https://demoqa.com");

        //Facem browserul in mod maximize

        driver.manage().window().maximize();

        //definim un obiect de tipul window method
        WindowMethod windowMethod = new WindowMethod(driver);

        //definim un obiect de tipul element method

        ElementMethod elementMethod = new ElementMethod(driver);

        //definim un obiect de tipul page method

        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/submeniul

        WebElement formMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //formMeniu.click();
        elementMethod.clickElement(formMeniu);

        WebElement practiceformMeniu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //practiceformMeniu.click();
        elementMethod.clickElement(practiceformMeniu);

        //First name
        WebElement firstName = driver.findElement(By.id("firstName"));
        String firstNameValue = "Dania";
        //firstName.sendKeys(firstNameValue);
        elementMethod.fillElement(firstName, firstNameValue);

        //Last name
        WebElement lastName = driver.findElement(By.id("lastName"));
        String lastNameValue = "Shaorma";
        //lastName.sendKeys(lastNameValue);
        elementMethod.fillElement(lastName, lastNameValue);

        //email address
        WebElement emailAccountElement = driver.findElement(By.id("userEmail"));
        String emailAccountValue = "dania.Shaorma@gmail.com";
        //emailAccountElement.sendKeys(emailAccountValue);
        elementMethod.fillElement(emailAccountElement, emailAccountValue);

        //input[name='gender']
        //definim o logica generala de a selecta o lista
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));

        //facem un scroll la pagina pentru vizibilitate2
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,350)", "");

        String genderValue = "Male";
        if (genderElements.size() > 0) {
            switch (genderValue) {
                case "Male":
                    //genderElements.get(0).click();
                    elementMethod.clickElement(genderElements.get(0));
                    break;
                case "Female":
                    //genderElements.get(1).click();
                    elementMethod.clickElement(genderElements.get(1));
                    break;
                case "Other":
                    //genderElements.get(2).click(); // Index corect pentru "Other"
                    elementMethod.clickElement(genderElements.get(2));
                    break;
            }
        }

        //Date of Birth
        WebElement dobElement = driver.findElement(By.id("dateOfBirthInput"));
        dobElement.click();
        WebElement dobMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dobMonthElement);
        //monthSelect.selectByVisibleText("June");
        elementMethod.selectByTextElement(dobMonthElement, "June");

        WebElement dobYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(dobYearElement);
        //yearSelect.selectByValue("1993");
        elementMethod.selectByValue(dobYearElement, "1995");

        List<WebElement> dobDayElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String weekDaysValues = "25";
        for (
                Integer index = 0; index < dobDayElements.size(); index++) {
            if (dobDayElements.get(index).getText().equals(weekDaysValues))
            {
                dobDayElements.get(index).click();
                break;
            }
        }

        //User number
        WebElement numberElement = driver.findElement(By.id("userNumber"));
        String numberValue = "1234567890";
        //numberElement.sendKeys(numberValue);
        elementMethod.fillElement(numberElement, numberValue);

        //Subject Input
        WebElement AccountElement = driver.findElement(By.id("subjectsInput"));
        String subjectInputValue = "Accounting";
        //AccountElement.sendKeys(subjectInputValue);
        elementMethod.fillElement(AccountElement, subjectInputValue);
        //AccountElement.sendKeys(Keys.ENTER);
        elementMethod.pressElement(AccountElement,Keys.ENTER);

        //hobbiesWrapper
        //definim o logica generala de a selecta o lista de hobbies
        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValue = Arrays.asList("Sports", "Reading", "Music");

        // Parcurgem lista de elemente pentru hobbies
        for (WebElement hobbieElement : hobbiesElements) {
            // Obținem textul fiecărui element
            String hobbieText = hobbieElement.getText();
            // Dacă textul elementului se află în lista de valori dorite
            if (hobbiesValue.contains(hobbieText)) {
                // Facem scroll la elementul dorit pentru a fi vizibil
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", hobbieElement);

                // Așteptăm o scurtă perioadă de timp după ce facem scroll pentru ca elementul să se încarce complet
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Facem click pe elementul dorit folosind JavaScriptExecutor
                //JavascriptExecutor jsClick = (JavascriptExecutor) driver;
                //jsClick.executeScript("arguments[0].click();", hobbieElement);
                elementMethod.clickJSElement(hobbieElement);
            }
        }

        //Interactiune cu un fisier: uploadpicture
        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        String pictureValue = "tuiasi.png";

        // Creăm calea absolută corectă pentru fișier
        File file = new File("src/test/resources/" + pictureValue);
        pictureElement.sendKeys(file.getAbsolutePath());

        //Interactionam cu Adresa
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Iashington";
        addressElement.sendKeys(currentAddressValue);

        //Interactionam cu Statul din adresa
        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethod.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        //stateInputElement.sendKeys(stateInputValue);
        //stateInputElement.sendKeys(Keys.ENTER);
        elementMethod.fillElement(stateInputElement, stateInputValue);
        elementMethod.pressElement(stateInputElement, Keys.ENTER);

        //Interactionam cu orasul din adresa
        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementMethod.clickElement(cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        //cityInputElement.sendKeys(cityInputValue);
        //cityInputElement.sendKeys(Keys.ENTER);
        elementMethod.fillElement(cityInputElement, cityInputValue);
        elementMethod.pressElement(cityInputElement, Keys.ENTER);

        //button[@id='submit']
        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethod.clickElement(submitElement);

        //validam tabelul cu valorile introduse
        WebElement thankyouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankyouMessageElement.getText(), "Thanks for submitting the form");

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);

        Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + emailAccountValue);

        Assert.assertEquals(tableValues.get(2).getText(), "Gender " + genderValue);

        Assert.assertEquals(tableValues.get(3).getText(), "Mobile " + numberValue);

        Assert.assertEquals(tableValues.get(5).getText(), "Subjects " + subjectInputValue);

        //Assert pentru hobbies
        // Obține valoarea din tabel
        String actualHobbiesText = tableValues.get(6).getText();

        // Formatează lista de valori așteptate pentru hobby-uri
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValue);

         // Compara valorile
        Assert.assertEquals(actualHobbiesText, expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(), "Picture " + pictureValue);

        Assert.assertEquals(tableValues.get(8).getText(), "Address " + currentAddressValue);

        Assert.assertEquals(tableValues.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);


        //button[@id='closeLargeModal']
        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeElement);

    }

}
