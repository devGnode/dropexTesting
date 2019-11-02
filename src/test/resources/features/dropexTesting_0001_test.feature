@test @frontal
Feature: Test

  @severity=low
  Scenario Outline: navigation test
    Given I navigate to home page
    And I check balance bitcoin addr "<addr>"

  Examples:
    | addr                               |
    | 1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa |