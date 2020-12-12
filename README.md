# Swagger
This repository is created to upload API tests for Problem statement provided by Steerlean Consultancy for Coding Assignment for API Automation Tester position

Commit : 1
Postman Collection with below requests :
{{base_url}} - environment variable for : https://petstore.swagger.io/v2
1.Find a pet status : 
method :  GET
request url :  {{base_url}}/pet/findByStatus?status={{status}}
response : loop through the response containing all "available" pets and fetch one pet_id and set it into enviromnemt variable - {{pet_id}}
Description : Finding a pet by status "Available" - passed as environment variable - {{status}}
                     Then set the pet id found in above request as environment variable - {{pet_id}}

2. Place order for the available pet in a store :
Method : POST
content-type : application/json
Body : 
{
  "id": 10,
  "petId": "{{pet_id}}",
  "quantity": 0,
  "shipDate": "2020-12-11T13:46:31.349Z",
  "status": "placed",
  "complete": true
}
request url : {{base_url}}/store/order

Description : This request uses {{pet_id}} from the response of above request.
This request returns response with response containing order id :
{
    "id": 10,
    "petId": 9222968140496864000,
    "quantity": 0,
    "shipDate": "2020-12-11T13:46:31.349+0000",
    "status": "placed",
    "complete": true
}


