package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {

By openAccountTab = By.xpath("//button[normalize-space()='Open Account']");
By searchCustomer = By.xpath("//select[@id='userSelect']");
By selectCurrency = By.xpath("//select[@id='currency']");
By processButton = By.xpath("//button[normalize-space()='Process']");

public void clickOnOpenAccountTab(){
    clickOnElement(openAccountTab);
}

public void clickOnProcessButton(){
    clickOnElement(processButton);
}

public void searchCustomer(){
    //selectByVisibleTextFromDropDown(searchCustomer, "Harry");
    selectByIndexFromDropDown(searchCustomer, 2);
}
public void searchCurrency(){
    selectByContainsTextFromDropDown(selectCurrency, "Pound");

}

}
