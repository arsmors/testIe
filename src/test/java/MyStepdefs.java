import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseFunc;
import pages.MainPage;

public class MyStepdefs {
    private BaseFunc baseFunc = new BaseFunc();
    private MainPage mainPage = new MainPage(baseFunc);

    @Given("website with link {string}")
    public void websiteWithLink(String url) {
        baseFunc.openPage(url);
    }

    @When("user click {string} main section")
    public void userClickMainSection(String sectionName) {
        mainPage.selectMenuSection(sectionName);
    }

    @And("choose {string} section")
    public void chooseSection(String sectionName) {
        mainPage.selectSubMenuSection(sectionName);
    }
//
//    @Then("text {string} is displayed")
//    public void textIsDisplayed(String arg0) {
//    }
//
//    @When("user search for {string} in search section")
//    public void userSearchForInSearchSection(String arg0) {
//    }
}
