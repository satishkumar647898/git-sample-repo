import logging
import inspect


def customLogger(logLevel=logging.DEBUG):
    loggerName = inspect.stack()[1][3]
    logger = logging.getLogger(loggerName)
    logger.setLevel(logging.DEBUG)
    filehandler = logging.FileHandler("automation.log", "a")
    filehandler.setLevel(logLevel)
    formater = logging.Formatter('%(asctime)s : %(name)s : %(levelname)s : %(message)s',
                                 datefmt='%m/%d/%Y %I:%M:%S %p')
    filehandler.setFormatter(formater)
    logger.addHandler(filehandler)
    return logger







