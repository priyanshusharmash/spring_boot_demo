# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set workdir inside container
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
