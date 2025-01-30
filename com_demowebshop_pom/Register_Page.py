from com_demowebshop_pom.MasterPage import BasePage
from com_demowebshop_test.conftest import getRegisterData


class Register(BasePage):
    def __init__(self, driver):
        super().__init__(driver)

    gender_radio_btn = "gender-male"
    firstName_textfield = "FirstName"
    lastName_textfield = "LastName"
    email_textfield = "Email"
    password_textfield = "Password"
    confirmPassword_textfield = "ConfirmPassword"
    register_button = "register-button"
    validation_error_message = "//div[@class='validation-summary-errors']//li"

    def click_on_gender_radio_btn(self):
        self.click_on_element(self.gender_radio_btn, "id")

    def enter_firstName_into_respective_textfield(self, name):
        self.enter_data(self.firstName_textfield, "id", name)

    def enter_lastName_into_respective_textfield(self, lastName):
        self.enter_data(self.lastName_textfield, "id", lastName)

    def enter_email_into_respective_textfield(self, email):
        self.enter_data(self.email_textfield, "id", email)

    def enter_password_into_password_textfield(self, password):
        self.enter_data(self.password_textfield, "id", password)

    def enter_confirm_password_into_password_textfield(self, confirmPassword):
        self.enter_data(self.confirmPassword_textfield, "id", confirmPassword)

    def click_on_register_button(self):
        self.click_on_element(self.register_button, "name")

    def verify_error_message(self):
        error_message = self.get_text_from_element(self.validation_error_message, "xpath")
        return error_message.__eq__("The specified email already exists")
