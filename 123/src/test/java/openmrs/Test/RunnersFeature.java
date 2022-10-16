package openmrs.Test;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = { "src/test/resources/features" }
                , glue = { "openmrs.Definitions" }
                //,tags = "@tag4"
)

public class RunnersFeature {

}
