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
--header 'Content-Type: application/json' \
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
curl --location --request GET 'localhost:8083/patient/myappointments?patientName=pat1'
...

/prescription/save

...
curl --location --request POST 'localhost:8083/prescription/save' \
--header 'Content-Type: application/json' \
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