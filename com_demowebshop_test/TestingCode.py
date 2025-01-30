from selenium import webdriver


class Test:
    def test_123(self):
        driver = webdriver.Chrome()
        driver.maximize_window()
        driver.get("https://demowebshop.tricentis.com/")
        driver.quit()
