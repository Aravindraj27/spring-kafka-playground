### APIs Defined in this package.

#### Producer APIs

1. Curl call to post a string message to kafka
```bash
curl --location 'http://localhost:8080/api/producer/v1/string/messages' \
--header 'Content-Type: text/plain' \
--data 'Just Kidding'
```

2. Curl call to post a json to kafka
```bash
curl --location 'http://localhost:8080/api/producer/v1/json/messages' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 3,
    "firstName" : "asasdasdd",
    "lastName" : "Faasdasasdust",
    "email" : "asdavczxsd@outlook.com"
}'
```