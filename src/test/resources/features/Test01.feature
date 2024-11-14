Feature: Amazon

  @Amazon
  Scenario: Search for words on the Amazon site
    Given User goes to "amazonUrl"
    Then User validation title
    When User searches 1 word
    And User chooses a product
    And User writes product information to "productInfoPath"
    And User clicks add to card
    And User clicks go to card