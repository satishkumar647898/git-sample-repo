from com_demowebshop_generic.Base import BaseTest
from com_demowebshop_pom.Home_Page import Home
from com_demowebshop_pom.Register_Page import Register


class Repo(BaseTest):
    def __init__(self, driver):
        self.driver = driver
        self.home = Home(self.driver)
        self.register = Register(self.driver)
