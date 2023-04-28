FROM amazoncorretto:17-al2023-jdk


MAINTAINER mtaPortfolio

COPY target/mta-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080