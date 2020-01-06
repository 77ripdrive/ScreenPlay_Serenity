Feature: Search by keyword

  Scenario: Searching for a word
    Given <Name> is on the DuckDuckGo home page
    When he searches for <term>
    Then all the result titles should contain the word <term>
Examples:
|Name    | term     |
|Tom     | fish     |
|Jerry   | milk     |