
Feature: Delete purchase order
  Background:
  * def resp = call read('PlaceOrderForPet.feature')
  * def order_id = resp.id
 

  Scenario: Delete purchase order
    Given url 'https://petstore.swagger.io/v2/store/order' +'#(order_id)'
    When method delete
    Then status 200

