import org.matrix.pages.AccountActivityPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.matrix.infra.TestProperties;
import org.matrix.pages.DashboardPage;
import org.matrix.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class LoginPageTest.
 *
 * @author AbedZoabi
 */
@Test(testName = "Bank Sanity Test", description = "enter user name and password then click login then check the account details")
public class LoginPageTest extends BaseTest {

	private LoginPage login;
	private DashboardPage dashboard;

	private AccountActivityPage activityPage;
	/**
	 * Positive test getting country for "Island Trading" company
	 */
	@Test(testName = "LOGIN TEST")
	public void loginTestAndVerifyTable() {


		driver.get(TestProperties.getProperty("url"));


		login = new LoginPage();


		login.enterUsername("aiola6");
		login.enterPassword("Qwerty@11");

		login.clickLogin();
	}




	@Test(testName = "VERIFY ACCOUNT DETAILS")
	public void verifyAccountDetails() {


		dashboard = new DashboardPage();


		dashboard.clickAccountLink("13677");

		Assert.assertEquals(dashboard.getAccountText(), "Account Details");


		activityPage = new AccountActivityPage();

		String accountNumber = activityPage.getAccountNumber();
		Assert.assertEquals(accountNumber, "13677","Account Number Is NOT Correct");

		String accountType = activityPage.getAccountType();
		Assert.assertEquals(accountType, "CHECKING","Account Type Is NOT Correct");

		String accountBalance = activityPage.getBalance();
		Assert.assertEquals(accountBalance, "$100.00","Account Balance Is NOT Correct");


		String accountActiveBalance = activityPage.getAvailableBalance();
		Assert.assertEquals(accountActiveBalance, "$100.00","Account Available Balance Is NOT Correct");




		int transactionsCount = activityPage.getNumberofTransactions();
		Assert.assertEquals(transactionsCount, 4);


	}





	@Test(testName = "VERIFY ACCOUNT TRANSACTIONS")
	public void verifyAccountTransactions() {

		List<List<String>> expectedRowValues = new ArrayList<>();

		List<WebElement> transactions = activityPage.getTableRows();

		expectedRowValues.add(Arrays.asList("10-26-2023", "Funds Transfer Sent", "$50.00", ""));

		expectedRowValues.add(Arrays.asList("10-26-2023", "Funds Transfer Received", "", "$50.00"));

		expectedRowValues.add(Arrays.asList("10-26-2023", "Funds Transfer Sent", "$200.00", ""));

		expectedRowValues.add(Arrays.asList("10-26-2023", "Funds Transfer Received", "", "$200.00"));

		for (int i = 1; i < transactions.size(); i++) {
			List<WebElement> cells = activityPage.getTableCells(transactions.get(i));
			List<String> actualRowValues = new ArrayList<>();

			for (WebElement cell : cells) {
				actualRowValues.add(cell.getText());
			}

			Assert.assertEquals(actualRowValues, expectedRowValues.get(i - 1), "Transaction Number  " + i + " has different values");


		}

	}

}
