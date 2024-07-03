package Tests;


import HelperMethods.ElementMethod;
import HelperMethods.PageMethods;
import HelperMethods.WindowMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

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

        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMeniu.click();
        elementMethod.clickElement(elementsMeniu);

        WebElement webtableMeniu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webtableMeniu.click();
        elementMethod.clickElement(webtableMeniu);

        //definim un element dupa id
        //test 1: adaug un entry
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementMethod.clickElement(addElement);

        //dam un click pe id-ul identificat de la nume
        WebElement addNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Alex";
        //addNameElement.sendKeys(firstNameValue);
        elementMethod.fillElement(addNameElement, firstNameValue);

        //dam un click la id-ul identificat de last name
        WebElement addLastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Alejandros";
        //addLastNameElement.sendKeys(lastNameValue);
        elementMethod.fillElement(addLastNameElement, lastNameValue);

        //dam un click la id-ul identificat de email
        WebElement addemailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "exemple@exemple.com";
        //addemailElement.sendKeys(emailValue);
        elementMethod.fillElement(addemailElement, emailValue);

        //dam un click la id-ul identificat de age
        WebElement addageElement = driver.findElement(By.id("age"));
        String agelValue = "30";
        //addageElement.sendKeys(agelValue);
        elementMethod.fillElement(addageElement, agelValue);

        //dam un click la id-ul identificat de Salary
        WebElement addSalaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "300000";
        //addSalaryElement.sendKeys(salaryValue);
        elementMethod.fillElement(addSalaryElement, salaryValue);

        //dam un click la id-ul identificat de Department
        WebElement addDepartmentElement = driver.findElement(By.id("department"));
        String departmentValue = "ShaormaTester";
        //addDepartmentElement.sendKeys(departmentValue);
        elementMethod.fillElement(addDepartmentElement, departmentValue);

        //dam un click la id-ul identificat de Submit
        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethod.clickElement(submitElement);

        //test2: modific un entry existent
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        //editElement.click();
        elementMethod.clickElement(editElement);

        //dam un click la id-ul identificat de Department
        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "Dania Tester";
        //editDepartmentElement.clear();
        //editDepartmentElement.sendKeys(editDepartmentValue);
        elementMethod.clearFillElement(editDepartmentElement, editDepartmentValue);

        //click pe submit button
        WebElement clickSubmitElement = driver.findElement(By.id("submit"));
        //clickSubmitElement.click();
        elementMethod.clickElement(clickSubmitElement);

        //dam un click la id-ul de delete
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        //deleteElement.click();
        elementMethod.clickElement(deleteElement);




    }
}
