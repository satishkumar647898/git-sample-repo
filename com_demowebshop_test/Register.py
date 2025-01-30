from com_demowebshop_generic.Base import BaseTest
from com_demowebshop_generic.TestStatus import TestStatus
from com_demowebshop_pom.Home_Page import Home
from com_demowebshop_pom.Repo import Repo


class TestRegister(BaseTest):
    # testStatus = None

    def test_user_is_able_to_register_successfully(self, getRegisterData):
        self.repo = Repo(self.driver)
        self.testStatus = TestStatus(self.driver)
        self.repo.home.click_on_register_link()
        isDisplayed = self.repo.home.register_header_text_is_Displayed()
        self.testStatus.mark(str(isDisplayed), "Register Link is Displayed")
        self.repo.register.click_on_gender_radio_btn()
        self.repo.register.enter_firstName_into_respective_textfield(getRegisterData["name"])
        self.repo.register.enter_lastName_into_respective_textfield(getRegisterData["lastName"])
        self.repo.register.enter_email_into_respective_textfield(getRegisterData["email"])
        self.repo.register.enter_password_into_password_textfield(getRegisterData["password"])
        self.repo.register.enter_confirm_password_into_password_textfield(getRegisterData["password"])
        self.repo.register.click_on_register_button()
        message = self.repo.register.verify_error_message()
        self.testStatus.mark_final("test_user_is_able_to_register_successfully", message, "error message Verified")



