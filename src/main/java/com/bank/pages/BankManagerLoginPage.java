package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class BankManagerLoginPage extends Utility {

    By bankManagerLoginTab = By.xpath("//button[normalize-space()='Bank Manager Login']");
    By addCustomerTab = By.xpath("//button[normalize-space()='Add Customer']");
    By firstNameField = By.xpath("//input[@placeholder='First Name']");
    By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    By postcodeField = By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton = By.xpath("//button[@type='submit']");



    public void clickOnBankManagerLogin() {
        clickOnElement(bankManagerLoginTab);
    }

    public void clickOnAddCustomerTab() {
        clickOnElement(addCustomerTab);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastNameField, lName);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(postcodeField, postcode);
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(addCustomerButton);
    }

    public void clickOnAlertMessage(){
        acceptAlert();
    }




}
