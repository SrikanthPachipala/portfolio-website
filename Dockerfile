# Step 1: Use OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the JAR file to container
COPY target/Portfolio-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port
EXPOSE 9696

# Step 5: Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
