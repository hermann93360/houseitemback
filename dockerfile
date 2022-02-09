FROM openjdk:16-alpine3.13
WORKDIR /home
COPY /target/houseitem-0.0.1-SNAPSHOT.jar houseitem-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "houseitem.jar"]
