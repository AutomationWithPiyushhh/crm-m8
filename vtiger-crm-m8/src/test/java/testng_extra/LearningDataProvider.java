package testng_extra;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearningDataProvider {
	
//	to execute same test script
//	multiple time
//	with the diff set of data
//	we will go for dataprovider
	
	@Test(dataProvider = "getData")
	public void fbLogin(String username, String password) throws InterruptedException {
//		hardcoded data
//		String username = "admin";
//		String password = "admin@123";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		new Actions(driver)
			.pause(Duration.ofSeconds(1))
			.sendKeys(username + Keys.TAB + password + Keys.ENTER)
			.build().perform();
		
		Thread.sleep(1000);
		driver.quit();	
	}
	
	@DataProvider
	public Object[][] getData() {
	    String[][] cred = new String[15][2];
//	    				num of row = exe, col => data

	    cred[0][0] = "baahubali_amar";     cred[0][1] = "Mahishmati@123";
	    cred[1][0] = "kgf_rocky";          cred[1][1] = "GoldMine#786";
	    cred[2][0] = "vikram_agent";       cred[2][1] = "GhostOps@007";
	    cred[3][0] = "leo_das";            cred[3][1] = "BloodySweet@1";
	    cred[4][0] = "pushpa_raj";         cred[4][1] = "FireHai@999";
	    cred[5][0] = "rrr_ram";            cred[5][1] = "Freedom#1947";
	    cred[6][0] = "rrr_bheem";          cred[6][1] = "JunglePower@11";
	    cred[7][0] = "master_vijay";       cred[7][1] = "JD@Master123";
	    cred[8][0] = "shivaji_boss";       cred[8][1] = "StyleBoss#1";
	    cred[9][0] = "surya_singham";      cred[9][1] = "PoliceForce@99";
	    cred[10][0] = "kabali_don";        cred[10][1] = "KabaliDa@555";
	    cred[11][0] = "arjun_reddy";       cred[11][1] = "LoveHate@21";
	    cred[12][0] = "kgf_adheera";       cred[12][1] = "VikingWar#77";
	    cred[13][0] = "valimai_ajith";     cred[13][1] = "NoFear@Ride";
	    cred[14][0] = "jailer_muthu";      cred[14][1] = "TigerMode@8";

	    return cred;
	}
}
