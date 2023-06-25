package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerABC implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Success");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Fail");
    }
}
