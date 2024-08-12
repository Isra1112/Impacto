FROM eclipse-temurin:17-jdk-alpine
LABEL authors="developer"
VOLUME /tmp
COPY target/Impacto-Pre-Interv-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
