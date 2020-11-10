import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  plugin = Array(
    "pretty",
    "html:target/cucumber-html-report.html",
    "json:target/cucumber.json"
  )
)
class RunCukesTest
