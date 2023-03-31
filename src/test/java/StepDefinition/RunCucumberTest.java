package StepDefinition;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
//gurkenSubtrahieren
//FeatureCompare 853
//UdemyStudenten 893
//pdfFunction  857
//checkoutWithoutLogin 832
//buffer 899
//flightcheck  946
//exerciseForm 949
//DragDrop 1007
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features/")
@IncludeTags("exerciseForm")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "")
public class RunCucumberTest {
}
