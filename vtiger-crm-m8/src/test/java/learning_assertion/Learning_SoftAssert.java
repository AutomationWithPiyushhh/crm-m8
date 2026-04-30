package learning_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Learning_SoftAssert { // => AssertionError
	@Test
	public void case1() {

		String a = "abc";
		String b = "bcd";
		String c = "abc";
		
		boolean status1 = a.equals(b); // false
		boolean status2 = a.equals(c); // true
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status1);
		sa.assertFalse(status2);
		
		System.out.println("the last line");
		sa.assertAll();
		sa.assertTrue(status1);
	}
}
