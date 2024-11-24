
FROM openjdk:18-jdk-slim

WORKDIR /app

COPY target/weather-0.0.1-SNAPSHOT.jar weather-backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "weather-backend.jar"]