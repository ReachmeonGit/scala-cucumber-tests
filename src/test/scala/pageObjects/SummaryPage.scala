package pageObjects

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory
import utils.DataContext

class SummaryPage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)

  @FindBy(how = How.CSS, using = "td[data-title='Unit price']")
  var productRow: WebElement = _

  @FindBy(how = How.CSS , using = "p.alert-warning")
  var cartEmptyWarning : WebElement = _

  def getPriceOfProduct() : String = {
    if (!cartEmptyWarning.isDisplayed()){
    return productRow.findElement(By.cssSelector("span.price")).getText
    }else return "$0"
  }
  
}
