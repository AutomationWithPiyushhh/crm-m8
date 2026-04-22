package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFBPage {
//	initialization
	public LoginFBPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	declaration
	@FindBy(name = "email")
	private WebElement un;

	public WebElement getUn() {
		return un;
	}

	@FindBy(name = "pass")
	private WebElement pwd;

	public WebElement getPwd() {
		return pwd;
	}

	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

}
