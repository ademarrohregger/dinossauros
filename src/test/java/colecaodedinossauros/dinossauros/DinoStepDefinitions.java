package colecaodedinossauros.dinossauros;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DinoStepDefinitions {
	
	DinoRepository repo = new DinoRepository();
	
	private static List<String> actualList;

	@Given("^There are dinosaurs in my repository$")
	public void There_are_dinosaurs_in_my_repository() throws Throwable {
		repo.addDinos("Tiranossauro-rex", "Abelisaurus", "Hadrossauro");
		Assert.assertFalse(repo.empty());
	}
	
	@When("^I list dinosaurs$")
	public void I_list_dinosaurs() throws Throwable {
	    actualList = repo.listNames();
	}

	@Then("^I see list of Dinosaurs$")
	public void I_see_list_of_Dinosaurs() throws Throwable {
	    Assert.assertTrue(actualList.contains("Tiranossauro-rex"));
	    Assert.assertTrue(actualList.contains("Abelisaurus"));
	    Assert.assertTrue(actualList.contains("Hadrossauro"));
	    actualList.clear();
	}

	@Given("^There are \"(.+)\" dinosaurs in my repository$")
	public void There_are_dinosaurs_in_my_repository(List<String> inputList) throws Throwable {
		for (String name : inputList) {
			repo.addDinos(name);
		}
		Assert.assertFalse(repo.empty());
	}

	@Then("^I see list \"(.+)\" of Dinosaurs$")
	public void I_see_list_of_Dinosaurs(List<String> expectedList) throws Throwable {
		for (String name : expectedList) {
			Assert.assertTrue(actualList.contains(name));
		}
		actualList.clear();
	}
	
	@Given("^The following dinosaurs exist in my repository:$")
	public void The_following_dinosaurs_exist_in_my_repository(DataTable tabela) throws Throwable {
		List<Map<String,String>> expectedList = tabela.asMaps();
		for (Map<String,String> element : expectedList) {
			repo.addDinos(element.get("name"));
		}
	}
	
	@Then("^I see the following list of Dinosaurs$")
	public void I_see_the_following_list_of_Dinosaurs(DataTable tabela) throws Throwable {
		List<Map<String,String>> expectedList = tabela.asMaps();
		for (Map<String,String> element : expectedList) {
			Assert.assertTrue(actualList.contains(element.get("name")));
		}
		actualList.clear();
	}
}
