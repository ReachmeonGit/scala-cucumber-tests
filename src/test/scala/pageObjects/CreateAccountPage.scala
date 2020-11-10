package pageObjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.JavascriptExecutor
import utils.DataContext
class CreateAccountPage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)

  @FindBy(how = How.ID, using = "submitAccount")
  var acct_creation_Submit: WebElement = _

  @FindBy(how = How.CSS, using = "#id_gender1")
  var title_Mr: WebElement = _

  @FindBy(how = How.ID, using = "customer_firstname")
  var first_name: WebElement = _

  @FindBy(how = How.ID, using = "customer_lastname")
  var last_name: WebElement = _

  @FindBy(how = How.ID, using = "passwd")
  var passwd: WebElement = _

  @FindBy(how = How.ID, using = "days")
  var days: WebElement = _

  @FindBy(how = How.ID, using = "months")
  var months: WebElement = _

  @FindBy(how = How.ID, using = "years")
  var years: WebElement = _

  @FindBy(how = How.ID, using = "firstname")
  var firstname: WebElement = _

  @FindBy(how = How.ID, using = "lastname")
  var lastname: WebElement = _

  @FindBy(how = How.ID, using = "address1")
  var address1: WebElement = _

  @FindBy(how = How.ID, using = "city")
  var city: WebElement = _

  @FindBy(how = How.ID, using = "id_state")
  var id_state: WebElement = _

  @FindBy(how = How.ID, using = "postcode")
  var postcode: WebElement = _

  @FindBy(how = How.ID, using = "id_country")
  var id_country: WebElement = _

  @FindBy(how = How.ID, using = "phone_mobile")
  var phone_mobile: WebElement = _

  @FindBy(how = How.ID, using = "alias")
  var alias: WebElement = _

  def createUserAccount(): Unit = {
    val js : JavascriptExecutor =  driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollBy(0,50)")
    
    val tempName: String = "BugTester"
    title_Mr.click()
    first_name.sendKeys(tempName)
    last_name.sendKeys(tempName)
    firstname.sendKeys(tempName)
    lastname.sendKeys(tempName)
    address1.sendKeys("XYZ , State , City , Country")
    city.sendKeys("New York")
    postcode.sendKeys("10001")
    phone_mobile.sendKeys("1234567891234")
    val drop: Select = new Select(id_state)
    drop.selectByValue("32")
    passwd.sendKeys(DataContext.password)
    acct_creation_Submit.click()
  }

}
