Feature: Add a new Pet
 
  Scenario: Add a new Pet to the Store
    Given url 'https://petstore.swagger.io/v2/pet' 
    And header Accept = 'application/json'
		And header Content-Type = 'application/json'
    When request read('pet.json')
    And method post
    Then status 200
   And match header Content-Type contains 'application/json'
