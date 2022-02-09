FROM openjdk:16-alpine3.13
WORKDIR /home
COPY /target/houseitem.jar houseitem.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "houseitem.jar"]
