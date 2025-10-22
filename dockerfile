FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /ecommerce-customers

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /ecommerce-customers

COPY --from=builder /ecommerce-customers/target/*.jar ecommerce-customers.jar

EXPOSE 9000

ENTRYPOINT ["sh", "-c", "java -jar ecommerce-customers.jar"]