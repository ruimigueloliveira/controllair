# FROM adoptopenjdk/openjdk11:alpine-jre
# COPY target/controllAir-0.0.1-SNAPSHOT.jar controllAir-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","/controllAir-0.0.1-SNAPSHOT.jar"]


FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]