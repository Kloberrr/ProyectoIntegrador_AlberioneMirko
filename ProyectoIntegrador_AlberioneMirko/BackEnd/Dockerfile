FROM amazoncorretto:17-alpine-jdk 
MAINTAINER MTA
COPY target/mta-0.0.1-SNAPSHOT.jar  mta-app.jar
ENTRYPOINT ["java","-jar","/mta-app.jar"]