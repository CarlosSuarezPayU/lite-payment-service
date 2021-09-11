FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn package

FROM openjdk:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/lite-payment-service.jar /app/