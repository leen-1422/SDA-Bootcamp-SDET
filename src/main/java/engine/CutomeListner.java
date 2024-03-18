package engine;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CutomeListner implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+ "test failed");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+ "test passed");
    }

}
