package com.demowebshop.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.demowebshop.generic.ExtentManager;

public class Register extends BasePage {
	private static WebElement ele;

	public Register(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement register_link;
	@FindBy(xpath = "//h1[text()='Register']")
	private WebElement Register_header;
	@FindBy(id = "FirstName")
	private WebElement firstName_textfield;
	@FindBy(id = "LastName")
	private WebElement lastName_textfield;
	@FindBy(id = "Email")
	private WebElement email_textfield;
	@FindBy(id = "Password")
	private WebElement Passowrd_textfield;
	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPassword_textfield;
	@FindBy(id = "register-button")
	private WebElement register_button;
	
	//stale element refrence exception: 

	public WebElement getRegister_link() {
		return register_link;
	}

	public void setRegister_link() {
		register_link.click();
		ExtentManager.logStep("Clicked on register link");
	}

	public WebElement getRegister_header() {
		return Register_header;
	}

	public void setRegister_header() {
		Assert.assertEquals(Register_header.isDisplayed(), true);
		Assert.assertEquals(Register_header.getText(), "Register");
	ExtentManager.logStep("Registe Header is displayed");

	}

	public WebElement getFirstName_textfield() {
		return firstName_textfield;
	}

	public void setFirstName_textfield() {
		firstName_textfield.sendKeys("Ravan");
		ExtentManager.logStep("Entered First Name");
	}

	public WebElement getLastName_textfield() {
		return lastName_textfield;
	}

	public void setLastName_textfield() {
		lastName_textfield.sendKeys("Raj");
		ExtentManager.logStep("Entered Last Name");
	}

	public WebElement getEmail_textfield() {
		return email_textfield;
	}

	public void setEmail_textfield() {
		email_textfield.sendKeys("ravanRaj@gmail.com");
	ExtentManager.logStep("Entered email id ");
	}

	public WebElement getPassowrd_textfield() {
		return Passowrd_textfield;
	}

	public void setPassowrd_textfield() {
		Passowrd_textfield.sendKeys("Password@123");
		ExtentManager.logStep("Entered password");
	}

	public WebElement getConfirmPassword_textfield() {
		return ConfirmPassword_textfield;
	}

	public void setConfirmPassword_textfield() {
		ConfirmPassword_textfield.sendKeys("Password@123");
	ExtentManager.logStep("Entered confirm password");
	}

	public WebElement getRegister_button() {
		return register_button;
	}

	public void setRegister_button(WebElement register_button) {
		this.register_button = register_button;
	}

	public void gender_RadioButton(String value) {
		String xpath = "//label[contains(text(),'Gender')]//following-sibling::div//input[@Value='" + value + "']";
		ele = driver.findElement(By.xpath(xpath));
		ele.click();
		ExtentManager.logStep("Clicked on gender radio button");
	}

}
