FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Departamento-1.0.0.jar departamentoCuchi.jar
ENTRYPOINT ["java","-jar","/departamentoCuchi.jar"]