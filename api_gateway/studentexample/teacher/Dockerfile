FROM openjdk:11
EXPOSE 9000
WORKDIR /app
COPY /target/teacher-0.0.1-SNAPSHOT.jar /app/teacher-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "teacher-0.0.1-SNAPSHOT.jar"]
