Feature: Pet Lifecycle

  Scenario: Create Update Delete Pet
    Given I create a pet
    When I fetch the pet
    Then pet should be available

    When I update pet status to "sold"
    Then pet status should be updated

    When I delete the pet
    Then pet should be deleted