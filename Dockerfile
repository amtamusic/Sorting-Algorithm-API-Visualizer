FROM openjdk:8-jdk-alpine
COPY target/Sorting-Algorithms-0.0.1-SNAPSHOT Sorting-Algorithms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Sorting-Algorithms-0.0.1-SNAPSHOT.jar"]