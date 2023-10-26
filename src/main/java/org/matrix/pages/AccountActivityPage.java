package org.matrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/* this class is handling the account activities such as details , transactions */

public class AccountActivityPage extends BasePage {

    @FindBy(css = "td#accountId")
    private WebElement accountNumber;

    @FindBy(css = "td#accountType")
    private WebElement accountType;

    @FindBy(css = "td#balance")
    private WebElement balance;

    @FindBy(css = "td#availableBalance")
    private WebElement availableBalance;

    @FindBy(id = "transactionTable")
    private WebElement transactionTable;



    public AccountActivityPage()  {

        PageFactory.initElements(driver, this);

    }


    public String getAccountNumber() {

        waitForElementTextNotEmpty(wait, new By.ByCssSelector("td#accountId"));
        return accountNumber.getText();
    }

    public String getAccountType() {
        return accountType.getText();
    }

    public String getBalance() {
        return balance.getText();
    }

    public String getAvailableBalance() {
        return availableBalance.getText();
    }

    public int getNumberofTransactions(){
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        return rows.size()-1;
    }

    public List<WebElement> getTableRows() {
        return transactionTable.findElements(By.tagName("tr"));
    }


    public List<WebElement> getTableCells(WebElement row) {
        return row.findElements(By.tagName("td"));
    }






}
