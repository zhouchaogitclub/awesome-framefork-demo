FROM  openjdk:8-jdk-alpine
ARG jar_file=*.jar
COPY ${jar_file} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]