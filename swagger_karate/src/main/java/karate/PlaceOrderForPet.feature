
Feature: Title of your feature
 Background:
  * def resp = call read('AddnewPet.feature')
  * def pet_id = resp.id
  * print resp.response.id
        
  Scenario: place order for pet_id +'#(pet_id)'
    Given url 'https://petstore.swagger.io/v2/store/order' 
    And header Accept = 'application/json'
		And header Content-Type = 'application/json'
    When request read('order.json')
    And method post
    Then status 200
    And def order_id = response.id
    And print '#(order_id)'
    