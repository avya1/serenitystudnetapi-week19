package com.studnetapp.studentinfo;

import com.studnetapp.constants.EndPoint;
import com.studnetapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

//@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {
    @Test
    public void getAllStudents(){
        SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_STUDENT)
                .then().log().all()
                .statusCode(200);
    }
    @Test
    public void thisIsFalling(){
        SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_STUDENT)
                .then().log().all().statusCode(400);
    }

    @Pending
    @Test
    public void thisIsAPending(){

    }
    @Ignore
    @Test
    public void thisIsASkipped(){

    }
    @Test
    public void thisIsATestWithError(){
        System.out.println("This is an Error " +(5/0) );
    }

    @Manual
    @Test
    public void thisIsManual(){


    }
    @Test
    public void thisIsCompromised() throws FileNotFoundException{
        File file =new File("E://file.txt");
        FileReader fileReader=new FileReader(file);
    }
    @Title("This test will get the information of all the student")
    @Test
    public void allStudentDetail(){
        SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_STUDENT)
                .then()
                .log().all().statusCode(200);
    }


}
