selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

The test is logging in with user and password then verify the details of the transcations and the account details.

NOTE - 
A.The user/password in this site is temporary only for one hour , so for testing purpose you need to :
   
   1. create user and password
   2. add two transcation the first one with 50$ and the other one with 200$
   3. edit the user password and account number in \src\test\java\LoginPageTest.java
   

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. Allure report

Steps to create test cases:
----
Let's say we want to automate Google search test.  

1.Create GoogleSearchPage in **pages** package.  
  A page class typically should contain all the elements that are present on the page and corresponding action methods.
  
  ```
  public class GooglePage extends AbstractPage {
	
	@FindBy(name = "q")
	private WebElement searchinput;

	public GooglePage(WebDriver driver) {
		super(driver);
	}

	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}

}
```
2.Create the test class which class the methods of GoogleSearchPage

```
@Test(testName = "Google search test", description = "Test description")
public class GoogleSearchTest extends BaseTest {

	@Test
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		GooglePage googlePage = PageinstancesFactory.getInstance(GooglePage.class);
		googlePage.searchText("abc");
		Assert.assertTrue(driver.getTitle().contains("abc"), "Title doesn't contain abc : Test Failed");
	}
}
```
3.Add the test class in testng.xml file under the folder `src/test/resources/suites/`

```
<suite name="Suite">
	<listeners></listeners>
	<test thread-count="5" name="Test" parallel="classes">
		<classes>
			<class name="tests.selenium.tests.GoogleSearchTest" />
```
4.Execute the test cases by maven command `mvn clean test`

---

Reproting
---
The framework uses Allure report framework

To get reports you need to install the Allure report and run the following commands:
The Allure report saves the results in the following directory:
"/allure-results"
`allure serve /allure-results`


---

Key Points:
---

1. The class `WebDriverContext` is responsible for maintaining the same WebDriver instance throughout the test. So whenever you require a webdriver instance which has been using for current test (In current thread) always call `WebDriverContext.getDriver()`.

---

