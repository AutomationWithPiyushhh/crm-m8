package learning_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(learning_listeners.Listener_Implementation.class)
public class Practice_Listeners {
	@Test
	public void create() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void modify() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "modify")
	public void delete() {
		Assert.assertTrue(false);
	}
}
