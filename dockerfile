FROM jdk-16.0.1_9-alpine
WORKDIR /home
COPY /target/houseitem.jar houseitem.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "houseitem.jar"]
