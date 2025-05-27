# Etapa de runtime: imagen ligera con JDK 17
FROM openjdk:17-jdk-slim AS runtime

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copia sólo el JAR compilado
COPY target/*.jar app.jar

# Puerto que expone tu Spring Boot (ajústalo si usas otro)
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java","-jar","/app/app.jar"]
