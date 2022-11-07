package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
				features = {"src/test/java/features/login.feature"},
				dryRun = !true,
				snippets = SnippetType.CAMELCASE,
				monochrome = true,
				glue = "steps",
				plugin = {"pretty","html:CucumberReports",
						  "json:reports/result.json",
						  "junit:reports/result.xml"},
						  tags = {"@positive"}
		)

public class Runner extends AbstractTestNGCucumberTests {

}
