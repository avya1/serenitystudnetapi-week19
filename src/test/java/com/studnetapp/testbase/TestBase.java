package com.studnetapp.testbase;


import com.studnetapp.constants.Path;
import com.studnetapp.utils.PropertyReader;
import gherkin.lexer.Pa;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;
    @BeforeClass
    public static void init(){
        propertyReader=PropertyReader.getInstance();
        RestAssured.baseURI=propertyReader.getProperty("baseUrl");
        RestAssured.port=Integer.parseInt(propertyReader.getProperty("port"));
        RestAssured.basePath= Path.STUDENT;
    }

}
