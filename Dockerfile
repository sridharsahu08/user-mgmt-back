FROM maven:3-jdk-8-alpine

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

ENV PORT 9090
EXPOSE $PORT
CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
