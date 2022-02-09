FROM openjdk:lasted
WORKDIR /home
COPY /target/houseitem.jar houseitem.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "houseitem.jar"]
