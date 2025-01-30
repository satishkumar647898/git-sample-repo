package com.demowebshop.testdev;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demowebshop.pom.CommonPage;

@Listeners(com.demowebshop.generic.CustomTestListener.class)
public class Register extends BaseTest{
	@Test
	public void verify_that_user_should_be_able_to_register() throws InterruptedException {
		CommonPage commonPage=new CommonPage(driver);
		commonPage.register.setRegister_link();
		commonPage.register.setRegister_header();
		commonPage.register.gender_RadioButton("M");
		commonPage.register.setFirstName_textfield();
		commonPage.register.setLastName_textfield();
		commonPage.register.setEmail_textfield();
		commonPage.register.setPassowrd_textfield();
		commonPage.register.setConfirmPassword_textfield();
		wait.wait_for_second(5);
		
	}

}
