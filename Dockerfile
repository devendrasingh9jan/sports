FROM maven:3.9.6 as builder
COPY . /sports/app
WORKDIR /sports/app
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /sports/app
COPY --from=builder /sports/app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
