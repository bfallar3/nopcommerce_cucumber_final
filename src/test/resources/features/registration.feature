Feature: Account Registration

  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters the details into below fields
      | firstName | Benjamin |
      | lastName  | Fallar |
      | password  | test@123 |
    And the user unselect Newsletter checkbox
    And the user clicks on Register button
    Then the user account should get created successfully