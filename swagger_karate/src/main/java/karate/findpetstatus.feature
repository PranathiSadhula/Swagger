
Feature: Fetch Pet status 
 
  Scenario: Fetch Pet status 
    Given url 'https://petstore.swagger.io/v2/pet/findByStatus' 
    When param status = 'avaiable'
    And method get
    Then status 200

 