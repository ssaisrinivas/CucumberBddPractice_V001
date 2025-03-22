package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableExampleSteps {

    @Given("User is on Registration Page")
    public void user_is_on_registration_page() {
	System.out.println("Opening the User Registration Page !!!!");
    }

    @When("User Enters following details")
    public void user_enters_following_details(DataTable dataTable) {

	List<List<String>> userList = dataTable.asLists();
	for (List<String> list : userList) {
	    System.out.println(list);
	}
    }

    @When("User Enters following details with colomns")
    public void user_enters_following_details_with_colomns(DataTable dataTable) {
	List<Map<String, String>> userMap = dataTable.asMaps();
	for (Map<String, String> map : userMap) {
	    Set<Entry<String, String>> entrySet = map.entrySet();
	    for (Entry<String, String> entry : entrySet) {
		System.out
			.println("The Keys is : " + entry.getKey() + "  ==> " + "  The Value is : " + entry.getValue());
		System.out.println();
	    }
	    System.out
		    .println("================================ Next Value !!!!!!! ==================================");
	}
    }

    @Then("I validate the outcomes")
    public void i_validate_the_outcomes() {
	System.out.println("User is validated !!!!");
    }

}
