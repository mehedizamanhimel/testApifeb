FROM maven: 3.8.4-jdk-8

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN mkdir -p /usr/src/app 
EXPOSE 8080 
WORKDIR /usr/src/app 
ADD . /usr/src/app 
RUN mvn clean test
