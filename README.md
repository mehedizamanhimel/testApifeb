# testApifeb
Sample Api automation test framework using restassured with Java and TestNG

To pull the docker image for assignment: 
- docker pull mehedizamansqa/testapi:latest


To run the tests in docker: 
- docker run -it -v `pwd`:/usr/src/app mehedizamansqa/testapi mvn clean test

To get the result in UI view from GitHub: 
1. testApifeb/target/surefire-reports/index.html
2. testApifeb/target/surefire-reports/emailable-report.html

Open the reports using browser to get the full detail view. 
