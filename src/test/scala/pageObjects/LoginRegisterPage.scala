package pageObjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.JavascriptExecutor
import utils.DataContext

class LoginRegisterPage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)

  @FindBy(how = How.ID, using = "email")
  var email: WebElement = _

  @FindBy(how = How.ID, using = "passwd")
  var password: WebElement = _

  @FindBy(how = How.ID, using = "SubmitLogin")
  var signin_button: WebElement = _

  @FindBy(how = How.ID, using = "email_create")
  var email_create: WebElement = _

  @FindBy(how = How.ID, using = "SubmitCreate")
  var submit_create: WebElement = _

  def logInWithEmailAndPassword(): Unit = {
    email.sendKeys(DataContext.email)
    password.sendKeys(DataContext.password)
    signin_button.click()
  }

  def registerWithEmail(): Unit = {
    email_create.sendKeys(DataContext.email)
    submit_create.click()
  }

  def checkLoginFieldsExist(): java.lang.Boolean = {
    val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollBy(0,100)")
    email.isDisplayed && password.isDisplayed
  }

  def checkRegisterEmailField(): java.lang.Boolean = {
    val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollBy(0,50)")
    email_create.isDisplayed
  }

}
