package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseFunc;
import pages.MainPage;
import pages.SearchPage;

public class MyStepdefs {
    private BaseFunc baseFunc = new BaseFunc();
    private MainPage mainPage = new MainPage(baseFunc);
    private SearchPage searchPage = new SearchPage(baseFunc);

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

    @Then("text {string} is displayed")
    public void textIsDisplayed(String text) {
        mainPage.searchResultsCheck(text);
    }

    @When("user search for {string} in search section")
    public void userSearchForInSearchSection(String search) {
        searchPage.enterSearchDetails(search);

    }

    @Then("appropriate message {string} is displayed in search results")
    public void appropriateIsDisplayedInSearchResults(String search) {
        searchPage.searchResults2(search);
        baseFunc.closePage();
    }
}
