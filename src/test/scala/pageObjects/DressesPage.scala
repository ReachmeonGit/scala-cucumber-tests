package pageObjects

import java.util.List
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory

import scala.collection.JavaConverters._
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Point
import org.openqa.selenium.Dimension


class DressesPage(driver: WebDriver) extends BasePage(driver) {

  PageFactory.initElements(driver, this)

  @FindBy(how = How.CSS, using = "#center_column > ul > li")
  var products: List[WebElement] = _

  @FindBy(how = How.CSS, using = "span[title='Continue shopping']")
  var continue_shopping_btn: WebElement = _

  @FindBy(how = How.CLASS_NAME, using = "shopping_cart")
  var cart: WebElement = _

  @FindBy(how = How.CSS, using = "a[title='View my shopping cart']")
  var cartLink: WebElement = _
  
  def cliclMostExpensiveDress(): Double = {
    val js : JavascriptExecutor =  driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollBy(0,100)")
    driver.manage().window().setSize(new Dimension(1000,1000))
    // driver.manage().window().setPosition(new Point(100 , 0))
    println(driver.manage().window().getSize().getWidth())
    var bigPrice: Double = 0.0
    var link: WebElement = null
    for (temp <- products.asScala) {
      
      val price: WebElement =temp.findElement(By.cssSelector(".right-block .price"))
      val priceText: String = price.getText
      val cPrice: Double = java.lang.Double.parseDouble(priceText.substring(1))
      
      if (bigPrice < cPrice) {
        bigPrice = cPrice
        link = temp.findElement(By.cssSelector("a[title = 'Add to cart']"))
      }
    }
    link.click()
    return bigPrice
  }

  def clickContinueShopping(): Unit = {
    continue_shopping_btn.click()
  }

  def checkCartHasItem(): String = {
    val js : JavascriptExecutor =  driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("window.scrollBy(0,-1000)")
    cart.getText
  }

  def openSummary(): Unit = {
    cartLink.click()
  }

}
