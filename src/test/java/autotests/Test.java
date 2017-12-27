package autotests;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.Result;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);

        for(Failure failure : result.getFailures()){
            logger.info(failure.toString());
        }
        logger.info(result.wasSuccessful());
    }
}
