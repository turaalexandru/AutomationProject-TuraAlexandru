package tests;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import helperMethods.WindowMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.io.File;
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

        //definim un obiect de tipul page method

        PageMethods pageMethods = new PageMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.navigateToFormMenu();

        //interactionam cu meniul/submeniul
        FormsPage formsPage = new FormsPage(driver);
        formsPage.navigateToPracticeForm();

        String firstNameValue = "Dania";
        String lastNameValue = "Shaorma";
        String emailNameValue = "absct@yahoo.com";
        String genderValue = "Male";
        String mobileNumberValue = "0723423451";
        String daysOfBirthValue = "1";
        String subjectInputValue = "Accounting";
        String picturePathValue = "tuiasi.png";
        String addressElementValue = "adresa";
        String stateInputValue = "Uttar Pradesh";
        String cityInputValue = "Agra";
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailNameValue, genderValue, mobileNumberValue, daysOfBirthValue,
                subjectInputValue, picturePathValue, addressElementValue, stateInputValue, cityInputValue, hobbiesValues);

        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, emailNameValue, genderValue, mobileNumberValue,
                subjectInputValue, hobbiesValues, picturePathValue, addressElementValue, stateInputValue, cityInputValue);

        // validam tabelul cu valorile introduse

    }

}
