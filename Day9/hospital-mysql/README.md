#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mysql.yml up -d
mvn spring-boot:run
docker-compose -f docker-compose-mysql.yml down
```
# Training
# /hospital/create
...
curl --location --request POST 'localhost:8081/hospital/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"hospid":"123",
"hospitalName":"Capital",
"address":"add1"
}'
...

# /hospital/view
...
curl --location --request GET 'localhost:8081/hospital/view'
...

# /hospital/update
...
curl --location --request PUT 'localhost:8081/hospital/update?id=1&address=add2'
...
# /patient/create
...
curl --location --request POST 'localhost:8081/patient/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"patid":"123",
"patName":"pat1",
"disease":"jaundice",
"hospital":"capital"


}'
...

# /patient/view

...
curl --location --request GET 'localhost:8081/patient/view'
...
