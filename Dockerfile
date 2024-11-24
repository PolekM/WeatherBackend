# Use an official OpenJDK image to run the application
FROM openjdk:18-jdk-slim

# Set the working directory inside the container
WORKDIR /weather

# Copy the compiled JAR file from your local machine to the container
COPY target/weather-0.0.1-SNAPSHOT.jar weather.jar

# Expose the port the app will run on (8080 is the default for Spring Boot)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "weather-backend.jar"]