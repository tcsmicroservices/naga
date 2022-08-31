#Create project
...
https://start.spring.io/
...

#Build the project
...
mvn clean install
...

#Run application
...
mvn spring-boot:run
...

#Testing the application

Save Data:
curl --location --request POST 'localhost:8081/save/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
"empId":"123",
"empName":"emp1",
"salary":"20000",
"department":"ÄWS"
}'



Get data:
curl --location --request GET 'localhost:8081/get/employee?empName=emp1' \
--header 'Content-Type: application/json' \
--data-raw '{
"empId":"123"
"empName":"emp"
"salary":"20000"
"department":"AWS"
}'

Update data:curl --location --request PUT 'localhost:8081/update/employee?empName=emp1&salary=30000'



Remove Data:
curl --location --request DELETE 'localhost:8081/remove/employee?empName=emp1'

