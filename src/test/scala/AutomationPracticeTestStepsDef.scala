import io.cucumber.scala.{EN, ScalaDsl, Scenario}

import org.junit.Assert._

// import org.openqa.selenium.Webdriver;
import org.openqa.selenium.WebElement;
import utils.SingeltonDriver

import pageObjects._

class AutomationPracticeTestStepsDef extends ScalaDsl with EN {
  var bigPrice: Double = 0

  var homePage: HomePage = _
  var loginRegisterPage: LoginRegisterPage = _
  var createAccountPage: CreateAccountPage = _
  var loggedinPage: LoggedinPage = _
  var dressesPage: DressesPage = _
  var summaryPage: SummaryPage = _
  // Open page
  Given("a new user to website") { () =>
    SingeltonDriver.driver.manage().window().maximize();
    SingeltonDriver.driver.navigate.to(BasePage.URL)
    homePage = new HomePage(SingeltonDriver.driver)
    loginRegisterPage = new LoginRegisterPage(SingeltonDriver.driver)
    createAccountPage = new CreateAccountPage(SingeltonDriver.driver)
    loggedinPage = new LoggedinPage(SingeltonDriver.driver)
    dressesPage = new DressesPage(SingeltonDriver.driver)
    summaryPage = new SummaryPage(SingeltonDriver.driver)
  }

  // Open Register and login page
  When("user click on Signin") { () =>
    homePage.clickSignIn()
  }

  // Confirm register email field
  Then("they see option to create a new account") { () =>
    assertTrue(loginRegisterPage.checkRegisterEmailField())
  }

  // Create a new Account
  And("enters the details to register") { () =>
    loginRegisterPage.registerWithEmail()
    createAccountPage.createUserAccount()
  }

  // Confirm Registeration
  Then("user is registered") {
    assertTrue(loggedinPage.checkLoggedIn())
  }
  // Confirm Login status
  Then("user is logged in") {
    assertTrue(loggedinPage.checkLoggedIn())
  }
  // Confirm login fields of email and password
  Then("they see option to Login") { () =>
    assertTrue(loginRegisterPage.checkLoginFieldsExist())
  }

  // Login with email and password
  And("enters the details to Login") { () =>
    {
      loginRegisterPage.logInWithEmailAndPassword()
    }
  }

  // Open Dress Page
  Then("the user click on dress tab") { () =>
    loggedinPage.clickDressesLink()
  }

  // Select Expensive dress
  And("the user select the expensive dress") { () =>
    bigPrice = dressesPage.cliclMostExpensiveDress()
    dressesPage.clickContinueShopping();
  }

  // Confirm expensive dress on cart Button
  Then("the user should see the product added to cart basket successfully") {
    () => assertTrue(dressesPage.checkCartHasItem().contains("Cart 1"))
  }
  // Confirm expensive dress on summary page
  And(
    "User should see correct product details in the shopping cart summary page"
  ) { () =>
    dressesPage.openSummary()
    val price: String = summaryPage.getPriceOfProduct().substring(1)
    assertEquals(bigPrice, price.toDouble, 0.0)
  }
  // Log out
  Then("user is logged out") { () =>
    loggedinPage.clickSignout()

  }
  Then("The customer log out and back in again") { () =>
    {
      loggedinPage.clickSignout()
      homePage.clickSignIn()
      loginRegisterPage.logInWithEmailAndPassword()
      loggedinPage.checkLoggedIn()
    }
  }
}
