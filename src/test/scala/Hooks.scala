import io.cucumber.scala.{ScalaDsl, EN, Scenario}
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebDriver
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriverException
import pageObjects._
import java.awt.Desktop
import java.io.File
import org.junit.BeforeClass
import org.junit.AfterClass
import utils._

class Hooks extends ScalaDsl with EN {
  
  Before { (scenario: Scenario) =>
    {
      SingeltonDriver.initialize()
      SingeltonDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      SingeltonDriver.driver.manage().deleteAllCookies()
    }
  }

  // Close Browser and driver
  After { (scenario: Scenario) =>
    {
      if (scenario.isFailed) {
        try {
          scenario.attach(
            "Current Page URL is " + SingeltonDriver.driver.getCurrentUrl,
            "text/plain",
            "Logs.txt"
          )
          val screenshot: Array[Byte] = SingeltonDriver.driver
            .asInstanceOf[TakesScreenshot]
            .getScreenshotAs(OutputType.BYTES)
          scenario.attach(screenshot, "image/png", "ScenerioFailed.png")
        } catch {
          case somePlatformsDontSupportScreenshots: WebDriverException =>
            println(somePlatformsDontSupportScreenshots.getMessage)

        }
      }
      SingeltonDriver.driver.quit()
    }
  }
  After("@report") { (_) =>
    new java.util.Timer().schedule(
      new java.util.TimerTask() {
        @Override
        def run() {
          val htmlFile: File = new File("target/cucumber-html-report.html");
          Desktop.getDesktop().open(htmlFile)
        }
      },
      5000
    );

  }

}
