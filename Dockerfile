FROM openjdk:8-jdk-alpine
EXPOSE 9372
ARG JAR_FILE=target/asistanceservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} asistanceservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","asistanceservice-0.0.1-SNAPSHOT.jar"]
