FROM openjdk:17-jdk-alpine AS build

WORKDIR /app

COPY . /app

RUN chmod +x gradlew
RUN ./gradlew build

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]