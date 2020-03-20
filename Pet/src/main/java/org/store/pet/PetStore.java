package org.store.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class PetStore {
	String response;
	String resource;
	ValidatableResponse rsp;

	public PetStore() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		resource = "v2/pet";
	}

	public void addPet(String petName, String id) {
		response = given().log().all().header("Content-Type", ContentType.JSON)
				.body(PayLoads.getAddPetPayload(petName, id)).when().post(resource).then().log().all().assertThat()
				.statusCode(200).extract().response().body().prettyPrint();
	}
	
	public void editPet(String petName, String id) {
		response = given().log().all().header("Content-Type", ContentType.JSON)
				.body(PayLoads.getAddPetPayload(petName, id)).when().put(resource).then().log().all().assertThat()
				.statusCode(200).extract().response().body().prettyPrint();
	}

	public boolean validateAddPetResponse(String petName) {
		JsonPath js = new JsonPath(response);
		String actualPetName = js.get("name");
		System.out.println("Actaul pet name is:" + actualPetName);
		System.out.println("Expected pet name is:" + petName);
		return actualPetName.equals(petName);
	}

	public void getPetById(String id) {
		String getResource = resource+"/"+id;
		rsp = given().log().all()
		.when().get(getResource)
		.then().log().all();
	}

	public void validateResponseCode(String rspCode) {
		rsp.assertThat().statusCode(Integer.parseInt(rspCode));
		response = rsp.extract().response().prettyPrint();
		
	}

	public void DeletePetById(String id) {
		String getResource = resource+"/"+id;
		rsp = given().log().all()
				.when().delete(getResource)
				.then().log().all();
	}


}
