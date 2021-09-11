# Lite Payment Service

This project was implements using:
  * Spring boot
  * Maven
  * Java 11
  * Wiremock
  * Postgres Database
  * Spring JPA

The MVP is to manage payments and process their _payment,_ and _refunds_, uses an anti fraud
validation service and before connect with the bank network service. The all transactions has saved 
into the database. 

**Note**: Always that the run the project the database is creating, to disable this change the `spring.jpa.hibernate.ddl-auto` 
into the `application.yaml` for `validate` value.


# Service important information

An interest data regarding to the project:

- **Current version**: 0.0.1-SNAPSHOT
- **Port**: `8086`
- **Payment Endpoint**: `/lite/payment`
- **Refund Endpoint**: `/lite/refund`
- **Anti Fraud Service Port**: `9001`
- **Anti Fraud Service Endpoint**: `/antifraud-validator/validate-operation`
- **Bank Service Port**: `9002`
- **Bank Service Endpoint**: `/bank-network/payment`

# Project structure

Below you can see a quick overview around the project scaffolding, it is important to highlight that the structure belongs
to the source code inside `/src/main/java/com/senior/test/litepaymentservice`

```
com/senior/test/litepaymentservice/           main package
|- application/                         Contains the application configuration.
|- infrastructure/                      Contains the services in charge of communication from and to the outside of the adapter
|- usecase/                             Contains the business and application logic.
+- share/                               Contains the classes that will be used throughout the project.
```

## Docker deployment

The project has dockerized, to run this you need executed the following steps:

1. Go to path `lite-payment-service/deployment`  and open a new terminal. 
2. Into the terminal execute `docker-compose up`. This command build a docker image and deploy 
   a container with the **lite-service-payment** and other with the **database**.
3. You can connect to database using this values:

- **host**: `localhost`
- **port**: `5434`
- **database**: `company`
- **user**: `liteuser`
- **password**: `l1t3s3rvic3`

## Request examples

Into the folder `/lite-payment-service/postman/` there is a **_postman collection_** 
called `LitePaymentService.postman_collection.json` when you will find examples of the 
lite-payment-service and the anti fraud and bank network mocks.

### Request examples important information.

If you want to create transactions you must have this in mind:

| Transaction Type  | Expect state     |  Credit card number | CVV2  |
|---|---|---|---|
|  Payment |  `APPROVED` | '4111111111111112' |  '777' |
|  Payment |  `DECLINED` by anti fraud  |  any |  '000' |
|  Payment |  `DECLINED` by bank  | '4111111111111111'  | '777'  |
|  Refund |  `APPROVED` |  '4111111111111112' | '777'  |
|  Refund |  `DECLINED` by anti fraud |  any | '000'  |
|  Refund |  `DECLINED` by bank | '4242424242424242'  |  '777' |