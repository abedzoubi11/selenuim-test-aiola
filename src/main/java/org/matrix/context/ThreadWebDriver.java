package org.matrix.context;

import org.openqa.selenium.WebDriver;

public class ThreadWebDriver {
    //Declare a ThreadLocal Driver for Thread-Safe executions to run tests in parallel without any problem.
    private static final ThreadLocal<WebDriver> tmDriver = new ThreadLocal<>();

    /**
     * Set driver to tmDriver
     *
     * @param webDriver
     */
    public static void setDriver(WebDriver webDriver) {
        tmDriver.set(webDriver);
    }

    /**
     * Get driver from tmDriver
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return tmDriver.get();
    }

    /**
     * Remove driver from tmDriver
     */
    public static void removeDriver() {
        tmDriver.remove();
    }
}
