package com.bank.testsuite;

import com.bank.pages.BankManagerLoginPage;
import com.bank.pages.CustomerLoginPage;
import com.bank.pages.OpenAccountPage;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();


    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLogin();
        //click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerTab();
        //enter FirstName
        bankManagerLoginPage.enterFirstName("John");
        //enter LastName
        bankManagerLoginPage.enterLastName("Smith");
        //enter PostCode
        bankManagerLoginPage.enterPostcode("xy27ct");
        //click On "Add Customer" Button
        bankManagerLoginPage.clickOnAddCustomerButton();
        //popup display
        //verify message "Customer added successfully"
        String actualMessage = bankManagerLoginPage.getTextFromAlert();
        Assert.assertEquals(actualMessage, "Customer added successfully with customer id :6", "Error message");
        acceptAlert();

    }


    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLogin();
        //click On "Open Account" Tab
        openAccountPage.clickOnOpenAccountTab();
        //Search customer that created in first test
        Thread.sleep(2000);
        openAccountPage.searchCustomer();
        Thread.sleep(2000);
        //Select currency "Pound"
        openAccountPage.searchCurrency();
        //click on "process" button
        openAccountPage.clickOnProcessButton();
        //popup displayed
        //verify message "Account created successfully"
        String actualMessage = bankManagerLoginPage.getTextFromAlert();
        String expectedMessage = "Account created successfully with account Number :1016";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message");
        openAccountPage.acceptAlert();
    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();

        Thread.sleep(3000);
        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //verify "Logout" Tab displayed.
        Thread.sleep(2000);
        String actualText = customerLoginPage.logoutText();
        String expectedText = "Logout";
        Assert.assertEquals(actualText, expectedText, "Error message");
        Thread.sleep(1000);

        //click on "Logout"
        customerLoginPage.clickOnLogoutTab();

        //verify "Your Name" text displayed.
        String actualName = customerLoginPage.verifyText();
        String expectedName = "Your Name :";
        Assert.assertEquals(actualName, expectedName, "Error message");
    }

    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();
        Thread.sleep(3000);

        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //click on "Deposit" Tab
        customerLoginPage.clickOnDepositTab();

        //Enter amount 100
        customerLoginPage.enterAmount("100");

        //click on "Deposit" Button
        customerLoginPage.clickOnDepositButton();

        //verify message "Deposit Successful"
        Assert.assertEquals(customerLoginPage.verifyDepositText(), "Deposit Successful", "Error message");

    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin();
        Thread.sleep(3000);

        //search customer that you created.
        customerLoginPage.searchCustomerName();

        //click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        Thread.sleep(2000);

        //click on "Deposit" Tab
        customerLoginPage.clickOnDepositTab();

        //Enter amount 100
        customerLoginPage.enterAmount("100");

        //click on "Deposit" Button
        customerLoginPage.clickOnDepositButton();


        /*int amt = customerLoginPage.returnBalanceAmount();
        System.out.println("balance before amt = " + amt);
        int withDrawalAmount = 100;
        if (amt < withDrawalAmount) {
            customerLoginPage.clickOnDepositTab();
            customerLoginPage.enterAmount(String.valueOf(withDrawalAmount));
            Thread.sleep(1000);
            customerLoginPage.clickOnDepositButton();
            Thread.sleep(1000);
            System.out.println("Balance after deposit = " + customerLoginPage.returnBalanceAmount());
            System.out.println("Amount to withdraw = " + withDrawalAmount);
        }*/


        //click on "Withdrawl" Tab
        customerLoginPage.clickOnWithdrawalTab();
        Thread.sleep(1000);
        // Enter amount 50
        customerLoginPage.enterAmount("50");
        Thread.sleep(1000);
        //click on "Deposit" Button
        customerLoginPage.clickOnWithdrawalButton();
        Thread.sleep(1000);
        //verify message "Transaction Successful"
        Assert.assertEquals(customerLoginPage.VerifyWithdrawalText(), "Transaction successful", "Error message");

    }

}
