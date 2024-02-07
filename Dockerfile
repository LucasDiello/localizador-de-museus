FROM eclipse-temurin:17-jdk-jammy as build-image
WORKDIR /to-build-app
COPY . .
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

FROM eclipse-mosquitto

WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
