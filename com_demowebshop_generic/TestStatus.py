from com_demowebshop_generic.Base import BaseTest


class TestStatus(BaseTest):

    def __init__(self, driver):
        self.driver = driver
        self.resultList = []

    def set_result(self, result, resultMessage):
        try:
            if result is not None:
                if result:
                    self.resultList.append("PASS")
                    self.log.info("### VERIFICATION SUCCESSFUL :: " + resultMessage)

                else:
                    self.resultList.append("FAIL")
                    self.log.info("### VERIFICATION FAILED :: " + resultMessage)
                    self.screenShot(resultMessage)

            else:
                self.resultList.append("FAIL")
                self.log.info("### VERIFICATION FAILED :: " + resultMessage)
                self.screenShot(resultMessage)
        except Exception as ec:
            self.resultList.append("FAIL")
            self.log.error("### EXCEPTION OCCURRED !!! " + str(ec))
            self.screenShot(resultMessage)

    def mark(self, result, resultMessage):
        self.set_result(result, resultMessage)

    def mark_final(self, testName, result, resultMessage):
        self.set_result(result, resultMessage)
        if "FAIL" in self.resultList:
            self.log.error(str(testName) + " ### TEST FAILED !!!")
            self.resultList.clear()
            assert True == False

        else:
            self.log.info(str(testName) + " ### TEST PASS SUCCESSFULLY !!!")
            self.resultList.clear()
            assert True == True
