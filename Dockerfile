FROM openjdk:17-oracle
MAINTAINER "Chris Chen chrisloveireland@gmail.com"
WORKDIR /app
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","./app.jar"]