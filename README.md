# Swagger
This repository is created to upload API tests for Problem statement provided by Steerlean Consultancy for Coding Assignment for API Automation Tester position

# Commit : 1 * Postman Collection for workflow test : Find Pet by status "available" and place order for the same
   ## Swagger.FindPetByStatusAndPlaceOrderForSame.json
    {{base_url}} - environment variable for : https://petstore.swagger.io/v2
    {{status}} - environment variable for : status = "Available"
> Requests Tested  
###  1.Find a pet by {{status}} : 
        method :  GET
        request url :  {{base_url}}/pet/findByStatus?status={{status}}
        response : loop through the response containing all "available" pets and fetch one pet_id and set it into enviromnemt variable - {{pet_id}}
    Description : Finding a pet by status "Available" - passed as environment variable - {{status}}
                     Then set the pet id found in above request as environment variable - {{pet_id}}

### 2. Place order for the {{status}} pet in a store : 
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
        response :  {
              "id": 10,
              "petId": 9222968140496864000,
              "quantity": 0,
              "shipDate": "2020-12-11T13:46:31.349+0000",
              "status": "placed",
              "complete": true
          }


# Commit :2 * Postman Collection for workflow test : Add a pet to the store and place an order
## Swagger.AddPetAndPlaceOrderForSame.json
> Requests Tested
## 1.Add a Pet to the store : 
        method :  POST
        request url :  {{base_url}}/pet
    Sample Request Body :
            {
              "id": 0,
              "category": {
                "id": 0,
                "name": "Beckiee"
              },
              "name": "doggie",
              "photoUrls": [
                "string"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "This is a new pet added"
                }
              ],
              "status": "available"
            }
    sample response with pet_id:
            {
                "id": 9222968140496864315,
                "category": {
                    "id": 0,
                    "name": "Beckiee"
                },
                "name": "doggie",
                "photoUrls": [
                    "string"
                ],
                "tags": [
                    {
                        "id": 0,
                        "name": "This is a new pet added"
                    }
                ],
                "status": "available"
            }
    Description : A record with pet details is generated.
    Tests performed on postman repsonse :
                var resp = pm.response.json();
                pm.environment.set("pet_id", resp.id);
                console.log(pm.environment.get("pet_id"));
    Above test sets pet_id as environment variable.

## 2. Place order for the available pet in a store :
            Method : POST
            content-type : application/json
    Request Body : 
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

# Commit :3 * Postman Collection with environment variables : Swagger.postman_environment.json
            {{base_url}} :  https://petstore.swagger.io/v2
            {{pet_id}} : pm.environment.set("pet_id", resp.id);
            {{order_id}} : pm.environment.set("order_id", resp.id);
            {{status}}  : Available (sold)
 
# Commit :4 * Postman Collection with below requests :Swagger.postman_collection.json
## 1. Add a pet to store : 
        request url : {{base_url}}/pet
        method : post
        request body : {{sample request}}
        content-type : application/json
        
## 2. Update an existing pet
        request url : {{base_url}}/pet
        method : put
        request body : {{sample request with update information}}
        content-type :application/json
 ## 3. find pet by status 
        request url : {{base_url}}/pet/findByStatus?status={{status}}
        method : GET
 ## 4. update a pet in the store with form data
        request url : {{base_url}}/pet/{{pet_id}}
        method : post
        Content-Type: application/x-www-form-urlencoded
        Request params : petId, name, status
 ## 5. Delete a pet
        request url : {{base_url}}/pet/{{pet_id}}
        method : DELETE
 ## 6. Place order for a pet
        request url : {{base_url}}/store/order
        method : put
        request body : {
                          "id": 10,
                          "petId": "{{pet_id}}",
                          "quantity": 0,
                          "shipDate": "2020-12-11T13:46:31.349Z",
                          "status": "placed",
                          "complete": true
                        }
        content-type :application/json
   ## 7. Find purchase order by ID
        request url : {{base_url}}/store/order/{{order_id}}
        method : GET
        sample response :
               {
                   "id": 1,
                   "petId": 124,
                   "quantity": 1,
                   "shipDate": "2020-12-12T17:18:30.000+0000",
                   "status": "placed",
                   "complete": false
               }
   ## 8. Delete a purchase order by ID
        request url : {{base_url}}/store/order/{{order_id}}
        method : DELETE   
