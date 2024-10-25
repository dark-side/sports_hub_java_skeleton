FROM eclipse-temurin:21.0.5_11-jdk-alpine AS build
WORKDIR /project

# Copy the Maven Wrapper files
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Ensure the Maven Wrapper is executable + Download dependencies
RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21.0.5_11-jre-alpine
RUN apk add dumb-init && \
    mkdir /app && \
    addgroup --system javauser && \
    adduser -S -s /bin/false -G javauser javauser && \
    rm -rf /var/cache/apk/*
COPY --from=build /project/target/*.jar /app/app.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD ["dumb-init", "java", "-jar", "app.jar"]