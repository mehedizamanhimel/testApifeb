package utils;

import io.restassured.RestAssured;

import java.io.IOException;

import static io.restassured.specification.ProxySpecification.host;

public class proxy {

    static TestData testData;

    public void setProxy() throws IOException {


        testData = new TestData();


        System.out.println("no proxy set");
        /*
        RestAssured.proxy = host(testData.properties.getProperty("proxy")).withPort(Integer.parseInt(testData.properties.getProperty("port")));
        System.out.println("proxy set up done");
         */
    }
}
