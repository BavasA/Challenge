package org.store.pet.stepDef;

import org.junit.Assert;
import org.store.pet.PetStore;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefnitions {
	PetStore petStore = new PetStore();

	@Given("^user adds pet \"([^\"]*)\" with \"([^\"]*)\" using post service$")
	public void user_adds_pet_with_using_post_service(String petName, String id) throws Throwable {
		System.out.println("Given user add pet using post service");
		petStore.addPet(petName, id);
	}

	@Given("^user edits pet \"([^\"]*)\" with \"([^\"]*)\" using post service$")
	public void user_edits_pet_with_using_post_service(String petName, String id) throws Throwable {
		System.out.println("Given user add pet using post service");
		petStore.editPet(petName, id);
	}

	@Then("^validate \"([^\"]*)\" in response$")
	public void validate_in_response(String petName) throws Throwable {
		System.out.println("Then pet should be added sucessfully");
		Assert.assertTrue(petStore.validateAddPetResponse(petName));
	}

	@Given("^user gets pet by \"([^\"]*)\"$")
	public void user_gets_pet_by(String id) throws Throwable {
		petStore.getPetById(id);
	}

	@Then("^Validate status code \"([^\"]*)\" in response$")
	public void validate_status_code_in_response(String rspCode) throws Throwable {
		petStore.validateResponseCode(rspCode);
	}
	
	@Given("^user deletes pet by \"([^\"]*)\"$")
	public void user_deletes_pet_by(String id) throws Throwable {
		petStore.DeletePetById(id);
	}
}
