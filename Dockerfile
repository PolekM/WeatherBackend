
FROM openjdk:17-jdk-slim

ENV SERVER_PORT=8080

WORKDIR /app

COPY target/weather-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]