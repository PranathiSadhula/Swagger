package swaggers.workflow.tests;

import org.testng.annotations.Test;

public class FindPetByStatusAndPlaceOrderForSame {

	@Test(dependsOnMethods = {"swaggers.pet.FindPetByStatus.testFindPetBySTatus", "swaggers.store.PlaceOrder.testPlacingAnOrderForPet"})
	public void testFindPetByStatusAndPlaceOrderForSame() {
		
	}
}
