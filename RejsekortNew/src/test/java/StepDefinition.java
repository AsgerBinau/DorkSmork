import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	TravelCard card = new TravelCard();
	InStation inStation;
	OutStation outStation;
	ResponseObject response;
	
	@Given("^rejsekort with balance of (\\d+)$")
	public void rejsekortWithBalanceOf(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("^Check-in status is false$")
	public void checkInStatusIsFalse() {
	    // Write code here that turns the phrase above into concrete actions
		int a = 2+2;
		int b = 0;
		int c = a/b;
	}

	@Given("^a check-in automaton at \"([^\"]*)\"$")
	public void aCheckInAutomatonAt(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
	    String[] a = new String[2];
	    a[5] = "asdf";
	}

	@When("^check-in$")
	public void checkIn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^automaton displays that the card is checked in$")
	public void automatonDisplaysThatTheCardIsCheckedIn() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^check more outcomes$")
	public void checkMoreOutcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
