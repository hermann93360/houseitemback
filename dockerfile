FROM openjdk:16-alpine3.13
WORKDIR /home
COPY /target/houseitem-0.0.1-SNAPSHOT.jar houseitem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "houseitem-0.0.1-SNAPSHOT.jar"]
