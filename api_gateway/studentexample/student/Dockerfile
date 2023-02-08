FROM openjdk:11
EXPOSE 8000
ADD target/student-0.0.1-SNAPSHOT.jar student-service
LABEL mentainer="tamilmani.kumarasamy@ideas2it.com"
WORKDIR /app
COPY /target/student-0.0.1-SNAPSHOT.jar /app/student-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "student-0.0.1-SNAPSHOT.jar"]
