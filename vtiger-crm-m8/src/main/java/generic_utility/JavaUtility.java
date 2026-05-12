package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class JavaUtility {
	public static int generateRandomNumber() {
		double ran = Math.random()*10000;
		int random = (int) ran;
		return random;
	}
	
	@Test
	public static String generateTime() {
		
		LocalDateTime now = LocalDateTime.now();
//		2026-05-12T14:42:39.206072500
		
		String time = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);
		return time;
	}
}
