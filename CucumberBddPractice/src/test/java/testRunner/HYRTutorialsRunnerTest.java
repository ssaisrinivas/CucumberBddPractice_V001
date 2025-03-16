package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "D:\\Eclipse-23-24\\CucumberBddPractice\\Features\\OrangeHrmAdminUsers.feature",
	"D:\\Eclipse-23-24\\CucumberBddPractice\\Features\\HYR_Tutorials.feature" }, glue = "stepDefinitions", plugin = {
		"pretty", "html:test-outputs.html" }, monochrome = true, dryRun = false)
//, tags = "@sanity"
public class HYRTutorialsRunnerTest {

}