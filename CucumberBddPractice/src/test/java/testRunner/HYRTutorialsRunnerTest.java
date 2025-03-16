package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
	"C:\\Users\\ssais\\git\\CucumberBddPractice_V001\\CucumberBddPractice\\src\\test\\resources\\Features\\OrangeHrmAdminUsers.feature",
	"C:\\Users\\ssais\\git\\CucumberBddPractice_V001\\CucumberBddPractice\\src\\test\\resources\\Features\\HYR_Tutorials.feature",
	"C:\\Users\\ssais\\git\\CucumberBddPractice_V001\\CucumberBddPractice\\src\\test\\resources\\Features\\DataTableExample.feature" }, glue = {
		"stepDefinitions", "hookes" },

	plugin = { "pretty",

		"html:test-outputs.html", "json:test-outputs.json", "junit:test-outputs.xml"

	}

	, monochrome = true, dryRun = false)
//, tags = "@sanity"
public class HYRTutorialsRunnerTest {

}