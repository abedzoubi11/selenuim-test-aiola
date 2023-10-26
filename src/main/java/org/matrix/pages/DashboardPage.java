package org.matrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DashboardPage extends AbstractPage {




    //clicking on the account by accountNumber
    public void clickAccountLink(String accountNumber) {
        WebElement accountLink = driver.findElement(By.cssSelector("a[href*='activity.htm?id="+accountNumber+"']"));
        accountLink.click();
    }

    //get the text after clicking on the account
    public String getAccountText() {
        WebElement accountText = driver.findElement(By.xpath("//h1[contains(text(),'Account Details')]"));
        return accountText.getText();
    }


    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }


}
