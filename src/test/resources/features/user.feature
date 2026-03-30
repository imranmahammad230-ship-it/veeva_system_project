Feature: User Security

  Scenario: Invalid user creation
    When I create invalid user
    Then user creation should fail

  Scenario: Fetch non-existent user
    When I fetch user "abc123"
    Then user should not be found

  Scenario: Invalid login
    When I login with username "wrong" and password "wrong"
    Then login should fail

  Scenario: Get existing user
    Given I create a valid user
    When I fetch user "testUser"
    Then user should be returned

  Scenario: Delete user
    Given I create a valid user
    When I delete user "testUser"
    Then user should be deleted