import helpers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseTestListener implements ITestListener {

    protected Logger logger;

    @Override
    public void onTestStart(ITestResult TestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult TestResult) {
        Driver.takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult TestResult) {
        Driver.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult TestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {

    }

    @Override
    public void onStart(ITestContext TestContext) {

    }

    @Override
    public void onFinish(ITestContext TestContext) {

    }

}
