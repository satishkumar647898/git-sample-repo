import logging


class LoggerDemoConsole:

    def testlog(self):
        # create logger
        logger = logging.getLogger(LoggerDemoConsole.__name__)

        # set logging level
        logger.setLevel(logging.INFO)

        # create console handler and set level of handler
        console_handler = logging.StreamHandler()
        console_handler.setLevel(logging.INFO)

        # create formater
        formater = logging.Formatter('%(asctime)s : %(name)s : %(levelname)s : %(message)s',
                                     datefmt='%m/%d/%Y %I:%M:%S %p')

        # add formater to console handler
        console_handler.setFormatter(formater)

        # add console handler to logger
        logger.addHandler(console_handler)

        # print message
        logger.debug("debug message")
        logger.info("info message")
        logger.warning("warning message")
        logger.error("error message")
        logger.critical("critical message")


demo = LoggerDemoConsole()
demo.testlog()
