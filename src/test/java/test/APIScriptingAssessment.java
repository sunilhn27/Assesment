package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.solution.constants.IAutoConst;
import com.solution.startup.BaseTest;

import io.restassured.RestAssured;

public class APIScriptingAssessment extends BaseTest {

	public static int id;

	@Test(priority = 1)
	public void createEmployee() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Sunil H N");
		map.put("salary", "1234");
		map.put("age", "26");
		responseSpec = responseSpecificationToGetToken(IAutoConst.CREATE_EMPLOYEE, map);
		response = given().spec(requestSpec).when().post().then().assertThat().extract().response();
		System.out.println(response.prettyPrint());
		id = response.jsonPath().getInt("data.id");

	}

	@Test(priority = 2)
	public void validateEmployee() {
		System.out.println("ID" + id);
		RestAssured.baseURI = IAutoConst.BASE_URI;
		response = given().when().get(IAutoConst.GET_EMPLOYEE + id).then().assertThat().extract().response();
		System.out.println(response.prettyPrint());
		AssertJUnit.assertEquals(response.jsonPath().getString("status"), "success");
		AssertJUnit.assertEquals(response.jsonPath().getString("data"), null);
		AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Successfully! Record has been fetched.");

	}

	@Test(priority = 3)
	public void deleteEmployee() {
		RestAssured.baseURI = IAutoConst.BASE_URI;
		response = given().when().delete(IAutoConst.DELETE_EMPLOYEE + id).then().assertThat().extract().response();
		System.out.println(response.prettyPrint());
		AssertJUnit.assertEquals(response.jsonPath().getString("status"), "success");
		AssertJUnit.assertEquals(response.jsonPath().getString("message"), "Successfully! Record has been deleted");

	}

}
