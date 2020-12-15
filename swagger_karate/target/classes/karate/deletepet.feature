
Feature: Delete the pet
Background:
  * def resp = call read('AddnewPet.feature')
  * def pet_id = resp.id
  * print resp.response.id
        
  Scenario: Delete Pet using petId
    Given url 'https://petstore.swagger.io/v2/pet/'+'#(pet_id)' 
   	When method delete
    Then status 200
