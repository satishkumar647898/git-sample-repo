from _ast import Assert

from selenium.webdriver.common.by import By

from com_demowebshop_pom.MasterPage import BasePage


class Home(BasePage):
    def __init__(self, driver):
        super().__init__(driver)

    register_link = "Register"
    register_header_text = "//h1[text()='Register']"

    def click_on_register_link(self):
        self.click_on_element(self.register_link, "link")
        currentUrl = self.driver.current_url
        print("current url is : "+currentUrl)
        title = self.driver.title
        print("current title is : "+title)

    def register_header_text_is_Displayed(self):
        isDisplayed = self.element_is_displayed(self.register_header_text, "xpath")
        return isDisplayed





