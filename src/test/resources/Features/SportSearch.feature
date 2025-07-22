Feature: Search Functionality

  Scenario: Validate search results for "Sport in 2023"
    Given I open the BBC Sport Grand Prix home page
    When I click on search icon
    When I search for "Sport in 2023"
    Then I should see at least 4 relevant search results
