package ListenersPack;

import org.testng.IReporter;
import java.util.Collection;

import java.util.Date;

import java.util.List;

import java.util.Map;

import java.util.Set;

import org.testng.IResultMap;

import org.testng.ISuite;

import org.testng.ISuiteResult;

import org.testng.ITestContext;

import org.testng.ITestNGMethod;

import org.testng.xml.XmlSuite;

public class ReporterClass implements IReporter {
    @Override

    public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuiteList,

                               String outputDirectory) {

        for (ISuite iSuite : iSuiteList) {
            Map<String, ISuiteResult> results = iSuite.getResults();
            Set<String> keys = results.keySet();
            for (String key : keys) {
                ITestContext context = results.get(key).getTestContext();
                System.out.println("Suite Name->" + context.getName()

                        + "::Report output Ditectory->" + context.getOutputDirectory()

                        + "::Suite Name->" + context.getSuite().getName()

                        + "::Start Date Time for execution->" + context.getStartDate()

                        + "::End Date Time for execution->" + context.getEndDate());

                IResultMap resultMapFailed = context.getFailedTests();
                Collection<ITestNGMethod> failedMethods = resultMapFailed.getAllMethods();
                System.out.println("--------FAILED TEST CASE---------");

                for (ITestNGMethod iTestNGMethod : failedMethods) {
                    System.out.println("TESTCASE NAME->" + iTestNGMethod.getMethodName()

                            + "\nDescription->" + iTestNGMethod.getDescription()

                            + "\nPriority->" + iTestNGMethod.getPriority()

                            + "\n:Date->" + new Date(iTestNGMethod.getDate()));
                }

                IResultMap resultMapPassed = context.getPassedTests();
                Collection<ITestNGMethod> passedMethods = resultMapPassed.getAllMethods();
                System.out.println("--------PASSED TEST CASE---------");

                for (ITestNGMethod iTestNGMethodPassed : passedMethods) {
                    System.out.println("TESTCASE NAME->" + iTestNGMethodPassed.getMethodName()

                            + "\nDescription->" + iTestNGMethodPassed.getDescription()

                            + "\nPriority->" + iTestNGMethodPassed.getPriority()

                            + "\n:Date->" + new Date(iTestNGMethodPassed.getDate()));


                }


            }


        }


    }
}
