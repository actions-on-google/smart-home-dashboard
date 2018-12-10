FROM openjdk:8-alpine

RUN apk add --no-cache nodejs npm maven

WORKDIR /code

COPY . .

WORKDIR /code/src/main/ngapp

RUN npm install
RUN npm run build

WORKDIR /code

RUN sed -ie '/Exclude Tomcat/,+7d' pom.xml

RUN mvn clean package spring-boot:repackage

CMD java -jar target/dashboard-0.1.0-SNAPSHOT.war
