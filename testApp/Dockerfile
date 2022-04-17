FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} testApp.jar
ENTRYPOINT ["java","-jar","/testApp.jar"]
EXPOSE 8080
