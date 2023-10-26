package org.matrix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @AbedZoabi
 */
public class BasePage extends AbstractPage{


	WebDriverWait wait = new WebDriverWait(driver,WAIT);
	public BasePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public static WebElement waitForElementTextNotEmpty(WebDriverWait wait, By elementLocator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));

		// Wait for the element's text to be non-empty
		wait.until((WebDriver d) -> {
			String text = element.getText();
			return !text.isEmpty();
		});

		return element;
	}

}
