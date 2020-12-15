Feature: Update existing pet with pet_id
Background:
  * def resp = call read('AddnewPet.feature')
  * def pet_id = resp.id
  * print resp.response.id
        
  Scenario: Update pet 
    Given  url 'https://petstore.swagger.io/v2/pet' 
    And header Accept = 'application/json'
		And header Content-Type = 'application/json'
    When request { id: '#(pet_id)', status: 'sold' }
    And method put
    Then status 200
   
    
  Scenario: Update pet using form data
    Given  url 'https://petstore.swagger.io/v2/pet' 
    When form field petId = '#(pet_id)'
		And form field name = 'forma data'
    And method put
    Then status 200