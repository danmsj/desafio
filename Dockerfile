FROM openjdk:12-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} desafio.jar
ENTRYPOINT ["java","-Xmx512m","-jar","/desafio.jar"]