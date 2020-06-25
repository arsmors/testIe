Feature: Search for a page

  Scenario Outline: Search for a page that does not exist
    Given website with link "https://aib.ie/"
    When user click "Ways to bank" main section
    And choose "Internet banking" section
    Then text "AIB Internet Banking" is displayed
    When user search for "addgdgagadg" in search section
    Then appropriate "<message>" is displayed in search results

    Examples:
      | message                                                  |
      | Your search - addgdgagadg - did not match any documents. |