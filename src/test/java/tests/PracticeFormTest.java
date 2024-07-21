package tests;

import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    public WebDriver driver;

    @Test
    public void metodaTest () {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormMenu();

        FormsPage formsPage = new FormsPage(getDriver());
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

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailNameValue, genderValue, mobileNumberValue, daysOfBirthValue,
                subjectInputValue, picturePathValue, addressElementValue, stateInputValue, cityInputValue, hobbiesValues);

        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, emailNameValue, genderValue, mobileNumberValue,
                subjectInputValue, hobbiesValues, picturePathValue, addressElementValue, stateInputValue, cityInputValue);

        // validam tabelul cu valorile introduse

    }

}
