package utils

import org.openqa.selenium.WebDriver

import SingeltonDriver._

object SingeltonDriver{

    var driver: WebDriver = _

    def initialize()={
        driver= BrowserMaping.getDriver()
    }
}
