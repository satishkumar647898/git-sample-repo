import os.path
import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
import logging
from com_demowebshop_generic import CustomLogger as cl


@pytest.mark.usefixtures("driver")
class BaseTest:
    driver: webdriver.Chrome
    log = cl.customLogger(logging.DEBUG)

    @pytest.fixture(autouse=True)
    def setup_driver(self, driver):
        self.driver = driver

    def Excel.javascreenShot(self, resultMessage):
        fileName = resultMessage+"."+str(round(time.time()*1000))+".png"
        screenshotDirectory = "../screenshots/"
        relativeFileName = screenshotDirectory+fileName
        current_directory = os.path.dirname(__file__)
        destination_file = os.path.join(current_directory, relativeFileName)
        destination_directory = os.path.join(current_directory, screenshotDirectory)
        try:
            if not os.path.exists(destination_directory):
                os.makedirs(destination_directory)
            self.driver.save_screenshot(destination_file)
            self.log.info("Screenshot save to directory "+destination_file)
        except Exception as ec:
            self.log.info("Exception occurred !!" + str(ec))

    def getByType(self, locatorType):
        locatorType = locatorType.lower()
        if locatorType == 'id':
            return By.ID
        elif locatorType == 'name':
            return By.NAME
        elif locatorType == 'tag':
            return By.TAG_NAME
        elif locatorType == 'css':
            return By.CSS_SELECTOR
        elif locatorType == 'xpath':
            return By.XPATH
        elif locatorType == 'link':
            return By.LINK_TEXT
        elif locatorType == "class":
            return By.CLASS_NAME
        else:
            print("locatorType", locatorType,"not correct or supported")
        return False

    def getElement(self, locator, locatorType=id):
        element = None
        try:
            locatorType = locatorType.lower()
            byType = self.getByType(locatorType)
            element = self.driver.find_element(byType, locator)
            self.log.info("Element found with locator : " + str(locator))
        except Exception as e:
            print(e)
            self.log.info("Element not found" + str(locator) + " and locator type is : " + str(locatorType))

        return element

    def click_on_element(self, locator, locatorType):
        try:
            self.getElement(locator, locatorType).click()
            self.log.info("Element Clicked with " + str(locator) + " and locator type is " + str(locatorType))
        except Exception as e:
            self.log.info(e)

    def enter_data(self, locator, locatorType, data):
        self.getElement(locator, locatorType).send_keys(data)
        self.log.info("Data Entered with" + str(locator) + " and locator type is " + str(locatorType))

    def element_is_displayed(self, locator, locatorType):
        self.log.info("Element is displayed with " + str(locator) + " and locator type is " + str(locatorType))
        return self.getElement(locator, locatorType).is_displayed()

    def get_text_from_element(self, locator, locatorType):
        self.log.info("successfully fetched text from " + str(locator) + " and locator type is " + str(locatorType))
        return self.getElement(locator, locatorType).text

    def wait_for_second(self, duration):
        time.sleep(duration)







