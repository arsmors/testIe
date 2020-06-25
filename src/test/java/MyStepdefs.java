import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseFunc;

public class MyStepdefs {
    private BaseFunc baseFunc = new BaseFunc();

    @Given("website with link {string}")
    public void websiteWithLink(String url) {
        baseFunc.openPage(url);
    }

//    @When("user click {string} main section")
//    public void userClickMainSection(String arg0) {
//    }
//
//    @And("choose {string} section")
//    public void chooseSection(String arg0) {
//    }
//
//    @Then("text {string} is displayed")
//    public void textIsDisplayed(String arg0) {
//    }
//
//    @When("user search for {string} in search section")
//    public void userSearchForInSearchSection(String arg0) {
//    }
}
