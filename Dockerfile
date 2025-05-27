# Etapa de runtime: imagen ligera con JDK 17
FROM openjdk:17-jdk-slim AS runtime

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
