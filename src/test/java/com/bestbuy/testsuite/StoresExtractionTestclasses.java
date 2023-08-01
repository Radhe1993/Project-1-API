package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTestclasses {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
        response.log().all();
    }

    //1. Extract the limit
    @Test
    public void limit() {
        int limit = response.extract().path("limit");
        System.out.println("Extract the limit " + limit);
    }

    //2. Extract the total
    @Test
    public void total() {
        int total = response.extract().path("total");
        System.out.println("Extract the total " + total);

    }

    //3. Extract the name of 5th store
    @Test
    public void name() {
        String name = response.extract().path("data[4].name");
        System.out.println("Extract the name of 5th store " + name);

    }

    //4. Extract the names of all the store
    @Test
    public void allName() {
        List<String> name = response.extract().path("data.name");
        System.out.println("Extract the name of 5th store " + name);

    }

    //5. Extract the storeId of all the store

    @Test
    public void storeId() {
        List<Integer> id = response.extract().path("data.id");
        System.out.println("Extract the name of 5th store " + id);
    }

    //6. Print the size of the data list

    @Test
    public void size() {
        List<String> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("Extract the name of 5th store " + dataList);

    }

    //7. Get all the value of the store where store name = St Cloud

    @Test
    public void stCould() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("Get all the value of the store where store name = St Cloud " + values);
    }

    //8. Get the address of the store where store name = Rochester

    @Test
    public void storeNAme() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("Get the address of the store where store name = Rochester" + address);

    }

    //9. Get all the services of 8th store

    @Test
    public void services() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("Get all the services of 8th store" + services);

    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void storeServices() {
        List<HashMap<String, ?>> storeServices = response.extract().path("data.services*.findAll{it.name=='Windows Store'}");
        System.out.println("Get storeservices of the store where service name = Windows Store" + storeServices);
    }

    //11. Get all the storeId of all the store

    @Test
    public void storeId1() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store " + storeId);
    }

    //12. Get id of all the store

    @Test
    public void allStore() {
        List<Integer> allId = response.extract().path("data.id");
        System.out.println("Get id of all the store " + allId);
    }

    //13. Find the store names Where state = ND

    @Test
    public void state() {
        List<String> state = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("Find the store names Where state = ND " + state);
    }

    //14. Find the Total number of services for the store where store name = Rochester

    @Test
    public void total1() {
        List<String> storName = response.extract().path("data.findAll{it.name=='Rochester'}.name");
        System.out.println("Find the Total number of services for the store where store name " + storName);
    }


    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void nameWindowsStore()
    {
        List<HashMap<String ,?>>  nameWindowsStore = response.extract().path("data.services*.findAll{it.name=='Windows Store'}.storeservices.createdAt");
        System.out.println("Get the createdAt for all services whose name = Windows Store" + nameWindowsStore);
    }

    //16. Find the name of all services Where store name = “Fargo”

    @Test
    public void Fargo()
    {
        List<String> fargo = response.extract().path("data.findAll{it.name=='Fargo'}.services*.name");
        System.out.println("Find the name of all services Where store name = “Fargo” "+fargo);
    }

    //17. Find the zip of all the store
    @Test
    public void zip()
    {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("Find the zip of all the store "+zip);

    }

    //18. Find the zip of store name = Roseville
    @Test
    public void zipStore()
    {
        List<String> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Find the zip of store name = Roseville "+zip);

    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void storeServices1()
    {
        List<HashMap<String ,?>> store = response.extract().path("data.services*.findAll{it.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("Find the storeservices details of the service name = Magnolia Home Theater "+store);

    }
    //20. Find the lat of all the stores

    @Test
    public void lat()
    {
        List<Double> lat = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores "+lat);
    }

}


