import pytest
from selenium import webdriver
from com_demowebshop_testdata.property import NavigationData
from com_demowebshop_testdata.registerData import Register


@pytest.fixture
def driver(request, getData):
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get(getData["url"])
    driver.implicitly_wait(20)
    driver.delete_all_cookies()
    driver.set_page_load_timeout(20)
    yield driver
    driver.quit()


@pytest.fixture(params=NavigationData.url)
def getData(request):
    return request.param


@pytest.fixture(params=Register.registerData)
def getRegisterData(request):
    return request.param
