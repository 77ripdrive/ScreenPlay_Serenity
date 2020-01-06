package stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nav.NavigateTo;
import net.thucydides.core.annotations.Steps;
import search.SearchFor;
import search.SearchResult;


import static matchers.TextMatcher.textOf;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchOnPage {
    @Steps
    NavigateTo navigateTo;

    @Steps
    SearchFor searchFor;

    @Steps
    SearchResult searchResult;

    @Given("^(?:.*) is on the DuckDuckGo home page")
    public void i_am_on_the_DuckDuckGo_home_page() {
        navigateTo.theDuckDuckGoHomePage();
    }

    @When("^s?he (?:searches|has searched) for \"(.*)\"")
    public void i_search_for(String term) {
        searchFor.term(term);
    }


    @When("^s?he (?:searches|has searched) again for \"(.*)\"")
    public void i_search_again_for(String term) {
        searchFor.termOnSearchResultsPage(term);
    }

    @Then("all the result titles should contain the word {string}")
    public void all_the_result_titles_should_contain_the_word(String expectedTerm) {
        assertThat(searchResult.titles())
                .allMatch(title -> textOf(title).containsIgnoringCase(expectedTerm));
    }
}
