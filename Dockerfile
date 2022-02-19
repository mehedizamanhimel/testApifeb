FROM maven:3.8.4-jdk-8
RUN mkdir -p /usr/src/app 
WORKDIR /usr/src/app 
ADD . /usr/src/app 
RUN mvn clean test


