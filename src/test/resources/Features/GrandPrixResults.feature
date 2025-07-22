Feature: Grand Prix Results

  Scenario: Validate top 3 finishers of the 2023 Las Vegas Grand Prix
    Given I open the BBC Sport Grand Prix home page
    When I click on search icon
    And I search for "Las Vegas Grand Prix 2023"
    Then I should see "Max Verstappen" in First place
    And I should see "George Russell" in Second place
    And I should see "Sergio Perez" in Third place
