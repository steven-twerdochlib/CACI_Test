# CACI_Test
CACI Java Test

# Installation
To run the application
1. From the terminal, got to the root directory containing the docker-compose.yml file.
2. Run the docker-compose.yml file with the command: 'docker-compose up -d'
3. Using the 'cd' command, go to the war file in: /caci_java_test/target/
4. Run the war file (Requires java17 installed) with the command: 'java -jar caci_java_test-0.0.1-SNAPSHOT.war'
5. Open a new terminal
6. Run Http requests (see possible http requests below)

# Possible Http Requests
Requires 'curl' installed if running from terminal, postman is another option.  
You need to replace any {variable} with an appropriate value.

curl -X GET http://localhost:8080/getAllOrders - Retrieves all orders of bricks.  
curl -X POST http://localhost:8080/dispatchedOrder?referenceNo={referenceNo} - Mark an order as dispatched. Returns http error 404 'Bad Request' if reference number doesn't exist.  
curl -X POST "http://localhost:8080/updateOrder?referenceNo={referenceNo}&numBricks={numBricks}" - Updates an order. Returns http error 404 'Bad Request' if reference number doesn't exist.  
curl -X POST http://localhost:8080/saveOrder?numBricks={numBricks} - Saves a new order with the given number of bricks, creating a random reference number for the new order.  
curl -X GET http://localhost:8080/getOrder?referenceNo={referenceNo} - Retrieves the order with the given reference number.
