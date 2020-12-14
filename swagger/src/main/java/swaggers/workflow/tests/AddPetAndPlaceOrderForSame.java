package swaggers.workflow.tests;

import org.testng.annotations.Test;

import swaggers.pet.AddNewPet;

public class AddPetAndPlaceOrderForSame {
	
	@Test(dependsOnMethods = {"swaggers.pet.AddNewPet.testAddingANewPet", "swaggers.store.PlaceOrder.testPlacingAnOrderForPet"})
	public void testAddPetAndPlaceOrderForSame() {
		
	}

}
