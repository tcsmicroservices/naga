# Build
...
mvn clean install
...

# Run
docker-compose -f docker-compose-rabbitmq.yml up -d rabbitmq-receiver> mvn spring-boot:run rabbitmq-sender> mvn spring-boot:run

# Test
$ curl --location --request GET 'http://localhost:8081/rabbitmq/sender?to=receiverr1&from=sender1&content=hello_receiver'

# Show data on browser::

http://localhost:15672/

user-name:guest password:guest

# Stop Container
docker-compose -f docker-compose-rabbitmq.yml down