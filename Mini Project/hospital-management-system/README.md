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
--header 'Authorization: Basic cGF0aWVudDpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=369D7B26541F430575B3C2EA016CE27A' \
--data-raw '{
"prescriptionId":"1",
"appointmentId":"1",
"description":"prescription1",
"patientName":"pat1",
"doctorName":"doc1"
}'
...

/patient/myappointment

...
curl --location --request GET 'localhost:8083/patient/myappointments?patientName=pat1' \
--header 'Authorization: Basic cGF0aWVudDpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=369D7B26541F430575B3C2EA016CE27A'
...

/prescription/save

...

curl --location --request POST 'localhost:8083/prescription/save' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3Jk' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=FB5C4927957E31FF696F39663E885505' \
--data-raw '{
"prescriptionId":"1",
"appointmentId":"1",
"description":"prescription1",
"patientName":"pat1",
"doctorName":"doc1"
}'
...

/prescription/view
...
curl --location --request GET 'localhost:8083/prescription/view?patientName=pat1' \
--header 'Authorization: Basic cGF0aWVudDpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=FB5C4927957E31FF696F39663E885505'
...

/doctor/appointments
...
curl --location --request GET 'localhost:8083/doctor/appointments?doctorName=doc1' \
--header 'Authorization: Basic ZG9jdG9yOnBhc3N3b3Jk' \
--header 'Cookie: JSESSIONID=468C1F092C16B75CC79058FAF327C15F'
...

# swagger
http://localhost:8083/swagger-ui/index.html

# code coverage
class 100%  Method 81%  Line 86%