FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/auction-registration-webapp-1.0-SNAPSHOT.jar auction-registration-webapp-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "auction-registration-webapp-1.0-SNAPSHOT.jar"]