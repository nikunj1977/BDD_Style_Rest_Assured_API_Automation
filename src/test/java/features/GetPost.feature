Feature: Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    And I perform Get for the post number "1"
    Then I should see the author name as "Dhruvin"

  Scenario: Verify parameter of GET
    Given I perform GET operation for "/post"
    Then I should see verify GET Parmeter

  Scenario: Verify POST Operation
    Given I perform POST operation for "/post"

  Scenario:Verify POST operation for profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
      |name|profile|
      |Sams|2      |
    Then I should see the body has name as "Sam"