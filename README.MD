# Payee Payment-API 

API accepts payment transactions ;
```json
 {
     "transactionId" : "transaction-id-123",
     "debtorIban" : "NL000000000000001",
     "creditorIban" : "NL000000000000002",
     "amount" : 1
 }
```
performs validation and sends a booking request to booking-system;
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<BookingRequest>
    <amount>1</amount>
    <creditorAccountManagementSystem>RAI</creditorAccountManagementSystem>
    <creditorIban>NL000000000000002</creditorIban>
    <debtorAccountManagementSystem>P7</debtorAccountManagementSystem>
    <debtorIban>NL000000000000001</debtorIban>
    <transactionId>transaction-id-123</transactionId>
</BookingRequest>
```
booking-system is a mock that acks every message and returns;
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<BookingResponse>
    <transactionId>transaction-id-123</transactionId>
    <code>0</code>
    <description></description>
</BookingResponse>
```

under _misc/docker/mysql-dump_ folder database initialization script can be found.

You can run whole application with the following components;
- mysql
- activemq
- api
- booking-system
- mock-callback  
by running **docker-compose up** (for shutdown **docker-compose down**)