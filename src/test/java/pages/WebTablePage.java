package pages;

import helperMethods.ElementMethod;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebDriver driver;
    public ElementMethod elementMethod;
    public PageMethods pageMethods;

    public WebTablePage (WebDriver driver) {
        this.driver = driver;
        elementMethod = new ElementMethod(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;

    @FindBy(id = "firstName")
    public WebElement addNameElement;

    @FindBy(id = "lastName")
    public WebElement addLastNameElement;

    @FindBy(id = "userEmail")
    public WebElement addemailElement;

    @FindBy(id = "age")
    public WebElement addageElement;

    @FindBy(id = "salary")
    public WebElement addSalaryElement;

    @FindBy(id = "department")
    public WebElement addDepartmentElement;

    @FindBy(id = "submit")
    public WebElement submitElement;

    @FindBy(id = "edit-record-4")
    public WebElement editElement;

    @FindBy(id = "department")
    public WebElement editDepartmentElement;

    @FindBy(id = "submit")
    public WebElement clickSubmitElement;

    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addEntry (String firstNameValue, String lastNameValue, String emailValue, String ageValue,
                          String salaryValue, String departmentValue) {
        elementMethod.clickElement(addElement);
        elementMethod.fillElement(addNameElement, firstNameValue);
        elementMethod.fillElement(addLastNameElement, lastNameValue);
        elementMethod.fillElement(addemailElement, emailValue);
        elementMethod.fillElement(addageElement, ageValue);
        elementMethod.fillElement(addSalaryElement, salaryValue);
        elementMethod.fillElement(addDepartmentElement, departmentValue);
        elementMethod.clickElement(submitElement);
    }

    public void editEntry (String editDepartmentValue) {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(editElement);
        elementMethod.clearFillElement(editDepartmentElement, editDepartmentValue);
        elementMethod.clickElement(submitElement);
    }

    public void deleteEntry () {
        pageMethods.scrollPage(0, 350);
        elementMethod.clickElement(deleteElement);
    }

}
