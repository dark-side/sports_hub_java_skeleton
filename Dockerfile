FROM maven:latest AS build
WORKDIR /project

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw && ./mvnw -B -q dependency:go-offline

COPY src ./src
RUN ./mvnw -B -q package -DskipTests

FROM maven:latest
RUN apt-get update \
 && apt-get install -y --no-install-recommends dumb-init \
 && groupadd --system javauser \
 && useradd -r -s /usr/sbin/nologin -g javauser javauser \
 && mkdir /app && chown -R javauser:javauser /app \
 && apt-get clean && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY --from=build /project/target/*.jar /app/app.jar
USER javauser
CMD ["dumb-init", "java", "-jar", "app.jar"]
