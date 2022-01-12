package com.studnetapp.studentinfo;

import com.studnetapp.constants.EndPoint;
import com.studnetapp.model.StudentPojo;
import com.studnetapp.testbase.TestBase;
import com.studnetapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StudentCRUDOperation extends TestBase {
    static String firstName="Abhuday"+ TestUtils.getRandomValue();
    static String lastName="Thakur"+TestUtils.getRandomValue();
    static String email=TestUtils.getRandomValue()+"123@gmail.com";
    static String programme="Api Testing";
    static int studentId;
    @Title("This will create a new student")
    @Test
    public void test001(){
        List<String> courseList=new ArrayList<>();
        courseList.add("C#");
        courseList.add("Java");
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastname(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);
        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .when()
                .post()
                .then().log().all().statusCode(201);
    }
    @Title("Verify if the student was added to the application")
    @Test
    public void test002(){
        String p1="findAll{it.firstName=='";
        String p2="'}.get(0)";
        HashMap<String,Object> value =SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_STUDENT)
                .then().statusCode(200)
                .extract()
                .path(p1+firstName+p2);
        Assert.assertThat(value,hasValue(firstName));
        studentId=(int)value.get("id");
    }
    @Title("Update the user information and verify the updated information")
    @Test
    public void test003(){
        firstName=firstName+"Updated";
        List<String> courseList = new ArrayList<>();
        courseList.add("C#");
        courseList.add("Java");
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastname(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courseList);
        SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("studentID", studentId)
                .body(studentPojo)
                .when()
                .put(EndPoint.DELETE_STUDENT_BY_ID)
                .then().log().all().statusCode(200);
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_STUDENT)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);
        Assert.assertThat(value, hasValue(firstName));

    }
    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004(){
        SerenityRest.given().log().all()
                .pathParam("studentID", studentId)
                .when()
                .delete(EndPoint.DELETE_STUDENT_BY_ID)
                .then().statusCode(204);

        SerenityRest.given()
                .pathParam("studentID", studentId)
                .when()
                .get(EndPoint.GET_SINGLE_STUDENT_BY_ID)
                .then()
                .statusCode(404);

    }



}
