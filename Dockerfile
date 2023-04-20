FROM openjdk:17
ADD target/docker-test.jar docker-test.jar
ENTRYPOINT ["java", "-jar","docker-test.jar"]
EXPOSE 8080