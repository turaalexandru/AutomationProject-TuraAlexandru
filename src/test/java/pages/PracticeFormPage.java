package pages;

import helperMethods.AlertMethod;
import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage {
    public WebDriver driver;
    public ElementMethod elementMethods;
    public PageMethods pageMethods;
    public AlertMethod alertMethods;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethod(driver);
        pageMethods  = new PageMethods(driver);
        alertMethods = new AlertMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameElement;

    @FindBy(id = "lastName")
    public WebElement lastNameElement;

    @FindBy(id = "userEmail")
    public WebElement emailElement;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> genderElements;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberElement;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement dateOfBirthMonthElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    public List<WebElement> daysOfBirthElements;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearOfBirth;

    @FindBy(id = "subjectsInput")
    public WebElement subjectInputElement;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> hobbiesElements;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureElement;

    @FindBy(id = "currentAddress")
    public WebElement addressElement;

    @FindBy(id = "state")
    public WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitForm;


    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    public List<WebElement> tableValue;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouMessageElement;



    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailNameValue,
                               String genderValue, String mobileNumberValue, String daysOfBirthValue,
                               String subjectInputValue, String picturePathValue, String addressElementValue,
                               String stateInputValue, String cityInputValue, List<String> hobbiesValues){
        elementMethods.fillElement(firstNameElement, firstNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);
        elementMethods.fillElement(emailElement, emailNameValue);
        pageMethods.scrollPage(0, 350);
        switch (genderValue){
            case "Male":
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderElements.get(1));
                break;
            case  "Other":
                elementMethods.clickElement(genderElements.get(2));
                break;
        }
        elementMethods.fillElement(mobileNumberElement, mobileNumberValue);
        elementMethods.clickElement(dateOfBirth);
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "September");
        elementMethods.selectByValue(yearOfBirth, "2024");
        for (Integer index = 0; index<daysOfBirthElements.size(); index++){
            if(daysOfBirthElements.get(index).getText().equals(daysOfBirthValue)){
                elementMethods.clickElement(daysOfBirthElements.get(index));
                break;
            }
        }
        pageMethods.scrollPage(0, 150);
        elementMethods.fillElement(subjectInputElement, subjectInputValue);
        elementMethods.pressElement(subjectInputElement, Keys.ENTER);
        pageMethods.scrollPage(0, 350);
        for(Integer index = 0; index<hobbiesElements.size(); index++) {
            String hobbieText = hobbiesElements.get(index).getText();
            if(hobbiesValues.contains(hobbieText)){
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }
        File file = new File("src/test/resources/" + picturePathValue);
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        elementMethods.fillElement(addressElement, addressElementValue);

        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(stateElement);

        elementMethods.fillElement(stateInputElement, stateInputValue);
        elementMethods.pressElement(stateInputElement, Keys.ENTER);

        elementMethods.fillElement(cityInputElement, cityInputValue);
        elementMethods.pressElement(cityInputElement, Keys.ENTER);
        pageMethods.scrollPage(0, 350);
        elementMethods.clickJSElement(submitForm);
    }

    public void validateEntireForm(String firstNameValue, String lastNameValue, String emailNameValue,
                                   String genderValue, String mobileNumberValue, String subjectInputValue, List<String> hobbiesValues,
                                   String picturePathValue, String addressElementValue,
                                   String stateInputValue, String cityInputValue){

        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        Assert.assertEquals(tableValue.get(0).getText(), "Student Name " + firstNameValue + " " + lastNameValue);
        Assert.assertEquals(tableValue.get(1).getText(), "Student Email " + emailNameValue);
        Assert.assertEquals(tableValue.get(2).getText(), "Gender " + genderValue);
        Assert.assertEquals(tableValue.get(3).getText(), "Mobile " + mobileNumberValue);
        Assert.assertEquals(tableValue.get(5).getText(), "Subjects " + subjectInputValue);
        String exceptedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValue.get(6).getText(), exceptedHobbiesText);
        Assert.assertEquals(tableValue.get(7).getText(), "Picture " + picturePathValue);
        Assert.assertEquals(tableValue.get(8).getText(), "Address " + addressElementValue);
        Assert.assertEquals(tableValue.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        //js.executeScript("arguments[0].click;", closeElement);
        elementMethods.clickJSElement(closeElement);

    }
}
