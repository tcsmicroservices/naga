# Build 
...
mvn clean install
...

# Run
...
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run
docker-compose -f docker-compose-mongo.yml down -d
...

# Training
/patient/bookappointment

...
curl --location --request POST 'localhost:8083/patient/bookappointment' \
--header 'Authorization: Basic dXNlcjEyMzpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=CD5B2A8BF6E2B9A28B0869010DB260D4' \
--data-raw '{
"appointmentId":"1",
"patientName":"pat1",
"doctorName":"doc1",
"date":"28-01-2022",
"presciption":"null"
}'
...

/patient/myappointment

...
curl --location --request GET 'localhost:8083/patient/myappointments?patientName=pat1' \
--header 'Authorization: Basic dXNlcjEyMzpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=CD5B2A8BF6E2B9A28B0869010DB260D4'
...

/prescription/save

...

curl --location --request POST 'localhost:8083/prescription/save' \
--header 'Authorization: Basic YWRtaW4xMjM6cGFzc3dvcmQ=' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=CD5B2A8BF6E2B9A28B0869010DB260D4' \
--data-raw '{
"prescriptionId":"1",
"appointmentId":"1",
"description":"jaundice disease prescription",
"patientName":"pat1",
"doctorName":"doc1"
}'
...

/prescription/view
...
curl --location --request GET 'localhost:8083/prescription/view?name=pat1'
...

/doctor/appointments
...
curl --location --request GET 'localhost:8083/doctor/appointments?doctorName=doc1'
...

# swagger
http://localhost:8083/swagger-ui.html

# code coverage
class 100%  Method 81%  Line 86%