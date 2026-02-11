FROM gradle:9.0.0-jdk21 AS build
WORKDIR /app

COPY gradle gradle
COPY gradlew build.gradle.kts settings.gradle.kts ./
RUN ./gradlew --no-daemon dependencies >/dev/null 2>&1 || true

# TODO после написания указать точные путь копирования
COPY . .
RUN ./gradlew --no-daemon clean build -x test

FROM eclipse-temurin:21-jre
WORKDIR /app

RUN useradd -r -u 10001 -g root -d /app -s /sbin/nologin coachdesk \
  && chown -R 10001:0 /app

COPY --from=build /app/build/libs/*.jar /app/app.jar
RUN chown 10001:0 /app/app.jar

USER 10001

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar"]