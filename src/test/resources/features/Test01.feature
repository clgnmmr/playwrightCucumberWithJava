Feature: Amazon

  @Amazon
  Scenario: Search for words on the Amazon site
    Given User go to "amazonUrl"
    Then User validation title