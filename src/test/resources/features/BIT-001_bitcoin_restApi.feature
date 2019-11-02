@restAPI @bitcoin @bitcoin-non-reg
Feature: Bitcoin check balance addr

  @severity=low
  Scenario Outline: Check balance of an addr
    Given I check balance bitcoin addr "<addr>"
    When I check last response status 200
    Then Balance value of this addr is equal to 18.114588F
    Examples:
      | addr                               |
      | 1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa |

  @severity=high
  Scenario Outline: check status of a bad addr
    Given I check balance bitcoin addr "<addr>"
    Then I check last response status 400
    Examples:
      | addr                               |
      | 1A1zP1eP5QGefi2DMPTfTL5SLmv7Div    |

  @severity=high
  Scenario Outline: check transaction
    Given I check balance bitcoin addr "<addr>"
    When I check last response status 200
    Then I should be able to see a tx id "<tx>"
    Examples:
      | addr                              | tx                                                                |
      | 1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa| 0f4a5242e30ef465a2e321604884f68aa145ec35858948c360cb515816aa1db7  |