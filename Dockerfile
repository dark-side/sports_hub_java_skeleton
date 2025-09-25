FROM eclipse-temurin:21.0.5_11-jdk-alpine AS build
WORKDIR /project

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw && ./mvnw -B -q dependency:go-offline

COPY src ./src
RUN ./mvnw -B -q package -DskipTests

FROM eclipse-temurin:21.0.5_11-jre-alpine
RUN apk add --no-cache dumb-init && \
    addgroup --system javauser && \
    adduser -S -s /sbin/nologin -G javauser javauser && \
    mkdir /app && chown -R javauser:javauser /app
WORKDIR /app
COPY --from=build /project/target/*.jar /app/app.jar
USER javauser
CMD ["dumb-init", "java", "-jar", "app.jar"]
