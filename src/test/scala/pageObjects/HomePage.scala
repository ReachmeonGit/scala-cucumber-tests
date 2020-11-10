package pageObjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory

class HomePage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)
  
  @FindBy(how = How.LINK_TEXT, using = "Sign in")
  var sign_in: WebElement = _

  def clickSignIn(): Unit = {
    sign_in.click()
  }

}
