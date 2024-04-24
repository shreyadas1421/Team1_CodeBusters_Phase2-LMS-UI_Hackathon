package cucumber.option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue="stepDefinations")
public class TestRunner  extends AbstractTestNGCucumberTests{

}
