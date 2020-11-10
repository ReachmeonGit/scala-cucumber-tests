package pageObjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory


class LoggedinPage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)
  
  @FindBy(how = How.LINK_TEXT, using = "Sign out")
  var sign_out: WebElement = _

  @FindBy(how = How.CSS, using = "#block_top_menu > ul > li:nth-child(2)")
  var dress_nav: WebElement = _

  def clickDressesLink(): Unit = {
    dress_nav.click()
  }

  def clickSignout(): Unit = {
    sign_out.click()
  }

  def checkLoggedIn(): java.lang.Boolean = sign_out.isDisplayed

}
