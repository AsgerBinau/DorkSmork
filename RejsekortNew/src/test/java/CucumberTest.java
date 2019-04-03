


 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType; 

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/",
	snippets = SnippetType.CAMELCASE)
public class CucumberTest {
}