Feature: Inventory

  Scenario: Validate inventory count
    When I get inventory
    And I fetch pets by status "available"
    Then counts should match