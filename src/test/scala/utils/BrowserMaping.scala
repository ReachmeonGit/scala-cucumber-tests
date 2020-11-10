package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import BrowserMaping._

object BrowserMaping {
  def getDriver(): WebDriver = {
      val browser = System.getProperty("browser")
      browser match {
        case "chrome"  => return new ChromeDriver()
        case "firefox" => return new FirefoxDriver()
        case "edge"    => return new EdgeDriver()
        case "IE"      => return new InternetExplorerDriver()
        case "opera"   => return new OperaDriver()
        case "safari"  => return new SafariDriver()
        case _         => return new ChromeDriver()
      }
  }
}
