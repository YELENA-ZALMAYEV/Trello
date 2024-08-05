package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static manager.TakeScreenShot.takeScreenShot;

public class WDListener extends AbstractWebDriverEventListener {//Deprecated realization WDListeners
    Logger logger = LoggerFactory.getLogger(WDListener.class);

    public WDListener(Logger logger) { //constructor
        this.logger = logger;
    }

    public WDListener() {     //to get massege, logger
        super();
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
        logger.info("navigate to --> " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
        logger.info("click on element --> " + element.getTagName());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        super.afterScript(script, driver);
        logger.info("run script --> " + script);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.error("start exception --> "+ throwable.toString());
        takeScreenShot((TakesScreenshot) driver); //+ import public methot
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
    }
}