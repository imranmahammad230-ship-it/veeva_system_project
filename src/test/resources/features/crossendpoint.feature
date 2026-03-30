Feature: Cross Endpoint Data Consistency

  Scenario: Validate cross endpoint consistency
    Given I create a pet with category "HighValue-Bulldog" and status "available"
    When I update pet status to "sold" for cross endpoint
    And I fetch store inventory
    And I fetch pets by status "sold" for cross endpoint
    Then created pet should be present in sold list