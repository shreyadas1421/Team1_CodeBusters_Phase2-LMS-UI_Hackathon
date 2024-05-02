package cucumber.option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue="stepDefinations"
				,plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				}
				)
public class TestRunner  extends AbstractTestNGCucumberTests{

}
