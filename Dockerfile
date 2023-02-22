FROM eclipse-temurin:11 AS build
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar #jar파일 생성

FROM eclipse-temurin:11
COPY --from=build build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "app.jar"]