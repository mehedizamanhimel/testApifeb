package com.nasa.api;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.TestData;
import utils.proxy;

import java.io.IOException;
import java.util.*;

public class GetData_Asteroid_Base {


    public GetData_Asteroid_Base() {

    }

    public ArrayList<String> des = new ArrayList<>();
    public ArrayList<String> orbit_id = new ArrayList<>();
    public ArrayList<String> jd = new ArrayList<>();
    public ArrayList<String> cd = new ArrayList<>();
    public ArrayList<String> dist = new ArrayList<>();
    public ArrayList<String> dist_min = new ArrayList<>();
    public ArrayList<String> dist_max = new ArrayList<>();
    public ArrayList<String> v_rel = new ArrayList<>();
    public ArrayList<String> v_inf = new ArrayList<>();
    public ArrayList<String> t_sigma_f = new ArrayList<>();
    public ArrayList<String> h = new ArrayList<>();


    public List<String> fieldsList;
    public List<Object> dataList;




    JsonPath jsonResponse;

    static TestData testData;


    //Http client for base api and storing the fields & data as an arrayList

    public void getBaseData(String param1_value,

                            String param2_value,

                            String param3_value,

                            String  param4_value) throws IOException {

        testData = new TestData();

        RestAssured.baseURI = testData.properties.getProperty("baseUrl");
        RestAssured.basePath = "/cad.api";


        jsonResponse = new JsonPath(RestAssured.given()
                .queryParam("des", param1_value)
                .queryParam("date-min", param2_value)
                .queryParam("date-max", param3_value)
                .queryParam("dist-max", param4_value)
                .contentType("application/json")
                .log()
                .all()
                .when()
                .get()
                .asString());

        jsonResponse.prettyPrint();

        fieldsList = new ArrayList<>(jsonResponse.getList("fields"));

        dataList = new ArrayList<>(jsonResponse.getList("data"));

    }



    public void getData_WithStatusCode(int StatusCode) throws IOException {

        testData = new TestData();

        RestAssured.baseURI = testData.properties.getProperty("baseUrl");
        RestAssured.basePath = "/cad.api";
        RestAssured.given()

/*
                .queryParam("des",param1_value)
                .queryParam("date-min", param2_value)
                .queryParam("date-max",param3_value)
                .queryParam("dist-max", param4_value)

 */
                .then()
                .log()
                .all()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(StatusCode);

    }



    public List returnFields(){
        return fieldsList;
    }

    public List returnData(){
        return dataList;
    }

    public Object returnSignature(){
        return jsonResponse.getJsonObject("signature");
    }

    public String returnCount(){
        return jsonResponse.getString("count");
    }



    // Getting all the values of data which is an array of array, and setting the fields variable based on the index.

    public  void getAllData_Field_Mapping(){

        for (int i =0; i <dataList.size(); i++){

            ArrayList<String> arr = (ArrayList<String>) dataList.get(i);
            for (int j = 0; j < arr.size() ; j++){
                //System.out.println("//"+arr.get(0));
                //des1 =  new ArrayList<>(Arrays.asList(arr.get(0))) ;
                des.add(arr.get(0));
                orbit_id.add(arr.get(1));
                jd.add(arr.get(2));
                cd.add(arr.get(3));
                dist.add(arr.get(4));
                dist_min.add(arr.get(5));
                dist_max.add(arr.get(6));
                v_rel.add(arr.get(7));
                v_inf.add(arr.get(8));
                t_sigma_f.add(arr.get(9));
                h.add(arr.get(10));

                break;
            }
        }
    }


    // Start of returning all the Data values of filter array via index ID

    public ArrayList<String> return_DataOf_Field_des(){
        return des;
    }

    public ArrayList<String> return_DataOf_Field_orbit_id(){
        return orbit_id;
    }

    public ArrayList<String> return_DataOf_Field_jd(){
        return jd;
    }

    public ArrayList<String> return_DataOf_Field_cd(){
        return cd;
    }

    public ArrayList<String> return_DataOf_Field_dist(){
        return dist;
    }

    public ArrayList<String> return_DataOf_Field_dist_min(){
        return dist_min;
    }

    public ArrayList<String> return_DataOf_Field_dist_max(){
        return dist_max;
    }

    public ArrayList<String> return_DataOf_Field_v_rel(){
        return v_rel;
    }

    public ArrayList<String> return_DataOf_Field_v_inf(){
        return v_inf;
    }

    public ArrayList<String> return_DataOf_Field_t_sigma_f(){
        return t_sigma_f;
    }

    public ArrayList<String> return_DataOf_Field_h(){
        return h;
    }

    // End of returning all the filter values in method via index ID


    // Method of sending the value of Fields array based on user input index
    public String getFields_basedOnInput(int itemNumber){
        return fieldsList.get(itemNumber);
    }

    //Start of sendinig the values of fields individually

    public String getFields_des(){
        return fieldsList.get(0);
    }

    public String getFields_orbit_id(){
        return fieldsList.get(1);
    }

    public String getFields_jd(){
        return fieldsList.get(2);
    }

    public String getFields_cd(){
        return fieldsList.get(3);
    }

    public String getFields_dist(){
        return fieldsList.get(4);
    }

    public String getFields_dist_min(){
        return fieldsList.get(5);
    }

    public String getFields_dist_max(){
        return fieldsList.get(6);
    }

    public String getFields_v_rel(){
        return fieldsList.get(7);
    }

    public String getFields_v_inf(){
        return fieldsList.get(8);
    }

    public String getFields_t_sigma_f(){
        return fieldsList.get(9);
    }

    public String getFields_h(){
        return fieldsList.get(10);
    }


    public int returnStringToInt_Fields(int fieldIndex){

        int param_int = Integer.parseInt(fieldsList.get(fieldIndex));

        return param_int;
    }

    public int returnStringToInt_Data(int dataIndex){

        int param_int = Integer.parseInt(fieldsList.get(dataIndex));

        return param_int;
    }

    public boolean verifyDesValues(){
        int fieldvalue_des = Integer.parseInt(fieldsList.get(0));
        int DataValue_Des = 0;
        for (int i = 0 ; i <des.size(); i ++){
            DataValue_Des = Integer.parseInt(des.get(i));
            if(fieldvalue_des!=DataValue_Des){
                return false;
            }
        }
        return true;
    }

}
