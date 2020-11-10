package pageObjects

import org.openqa.selenium.WebDriver
import BasePage._
object BasePage{
val URL : String ="http://automationpractice.com/index.php"
}
abstract class BasePage(driver: WebDriver)
