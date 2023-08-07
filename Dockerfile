FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} departamentoCuchi.jar
ENTRYPOINT ["java","-jar","/departamentoCuchi.jar"]
EXPOSE 8080