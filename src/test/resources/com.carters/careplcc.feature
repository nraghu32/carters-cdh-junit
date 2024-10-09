
Feature: Default offer corePLCCSignUp30
#  Valid environments are "dev", "staging"
#  Background:
#    Given Environment is "staging"

  @coreplcc @test
  Scenario: 1 - CorePLCCSignup30 should be served to the customer when PLCCCardHolder is false
    Given Generate Customer
      | firstName       | dateOfBirth      |pLCCCardHolder|
      | TestAutomation  | 1990-10-15       |FALSE         |
    Given Create email for Customer
    And Create a new "Web" Impression
    Then Check IH if action is served
      | CorePLCCSignup30       |

  @coreplcc @test
  Scenario: 1 - CorePLCCSignup30 should be served to the customer when PLCCCardHolder is false1
    Given Generate Customer
      | firstName       | dateOfBirth      |pLCCCardHolder|
      | TestAutomation  | 1990-10-15       |FALSE         |
    Given Create email for Customer
    And Create a new "Web" Impression
    Then Check IH if action is served
      | CorePLCCSignup30       |

  @coreplcc @test
  Scenario: 2 - CorePLCCSignup30 should not be served to the customer when PLCCCardHolder is true1
    Given Generate Customer
      | firstName       | dateOfBirth      |pLCCCardHolder|
      | TestAutomation  | 1990-10-15       |TRUE         |
    Given Create email for Customer
    And Create a new "Web" Impression
    Then Check IH if action is not served
      | CorePLCCSignUp30       |

  @coreplcc @test
  Scenario: 2 - CorePLCCSignup30 should not be served to the customer when PLCCCardHolder is true2
    Given Generate Customer
      | firstName       | dateOfBirth      |pLCCCardHolder|
      | TestAutomation  | 1990-10-15       |TRUE         |
    Given Create email for Customer
    And Create a new "Web" Impression
    Then Check IH if action is not served
      | CorePLCCSignUp30       |