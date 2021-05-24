FROM adoptopenjdk:11-jre-hotspot

# Specify JAR location
ARG JAR_FILE=target/*.jar
# Copy the JAR
COPY ${JAR_FILE} app.jar

ENV PORT 9090
EXPOSE $PORT
ENTRYPOINT ["java","-jar","/app.jar"]
