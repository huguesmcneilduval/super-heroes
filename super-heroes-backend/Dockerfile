FROM openjdk:8-jdk-alpine as builder
COPY src .
COPY pom.xml .
RUN mvn install

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/superheroes-0.0.1-SNAPSHOT.jar
COPY --from=builder ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
