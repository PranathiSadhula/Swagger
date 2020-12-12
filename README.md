# Swagger
This repository is created to upload API tests for Problem statement provided by Steerlean Consultancy for Coding Assignment for API Automation Tester position

# Commit : 1 * Postman Collection with below requests : Swagger.FindPetByStatusAndPlaceOrderForSame.json
    {{base_url}} - environment variable for : https://petstore.swagger.io/v2
    {{status}} - environment variable for : status = "Available"
  
##  1.Find a pet by {{status}} : 
        method :  GET
        request url :  {{base_url}}/pet/findByStatus?status={{status}}
        response : loop through the response containing all "available" pets and fetch one pet_id and set it into enviromnemt variable - {{pet_id}}
    Description : Finding a pet by status "Available" - passed as environment variable - {{status}}
                     Then set the pet id found in above request as environment variable - {{pet_id}}

## 2. Place order for the {{status}} pet in a store : 
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


# Commit :2 * Postman Collection with below requests : Swagger.AddPetAndPlaceOrderForSame.json
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
 
