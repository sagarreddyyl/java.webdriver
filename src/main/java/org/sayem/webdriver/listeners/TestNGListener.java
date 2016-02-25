package org.sayem.webdriver.listeners;

import org.sayem.webdriver.annotations.*;
import org.testng.*;

import java.lang.annotation.Annotation;

/**
 * Created by sayem on 2/24/16.
 */
public class TestNGListener implements IInvokedMethodListener2 {

    private String environment;
    private String browser;
    private String chrome;
    private String ie;
    private String firefox;
    private String safari;


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        for (ITestNGMethod m : context.getAllTestMethods()) {
            if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(Browser.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
                browser = m.getConstructorOrMethod().getMethod().getAnnotation(Browser.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(Chrome.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
                chrome = m.getConstructorOrMethod().getMethod().getAnnotation(Chrome.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(Firefox.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
                firefox = m.getConstructorOrMethod().getMethod().getAnnotation(Firefox.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(Safari.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
                safari = m.getConstructorOrMethod().getMethod().getAnnotation(Safari.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(InternetExplorer.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
                ie = m.getConstructorOrMethod().getMethod().getAnnotation(InternetExplorer.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Url.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(Url.class).value().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Browser.class)) {
                browser = m.getConstructorOrMethod().getMethod().getAnnotation(Browser.class).browser().getValue();
            }
        }

        if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                method.isTestMethod() && annotationPresent(method, Browser.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", browser);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                method.isTestMethod() && annotationPresent(method, Chrome.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", chrome);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                method.isTestMethod() && annotationPresent(method, Firefox.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", firefox);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                method.isTestMethod() && annotationPresent(method, Safari.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", safari);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                method.isTestMethod() && annotationPresent(method, InternetExplorer.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", ie);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class)) {
            System.setProperty("seleniumUrl", environment);
        } else if (method.isTestMethod() && annotationPresent(method, Browser.class)) {
            System.setProperty("browser", browser);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
    }

    private boolean annotationPresent(IInvokedMethod method, Class<? extends Annotation> clazz) {
        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz);
    }
}

