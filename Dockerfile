FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /project
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /project/src
RUN mvn clean package


FROM openjdk:17-oracle
MAINTAINER "Chris Chen chrisloveireland@gmail.com"
WORKDIR /app
ARG mongo_database
ARG mongo_user
ARG mongo_pswd
ARG mongo_cluster

ENV MONGO_DATABASE=$mongo_database \
    MONGO_USER=$mongo_user \
    MONGO_PSWD=$mongo_pswd \
    MONGO_CLUSTER=$mongo_cluster
COPY --from=build /project/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","./app.jar"]