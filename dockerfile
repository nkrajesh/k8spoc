# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="nkrajesh@hotmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

ENV	APP_PORT=8080
EXPOSE ${APP_PORT}

# Add the application's jar to the container
COPY target/*.jar app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","--server.port=${APP_PORT}","/app.jar"]