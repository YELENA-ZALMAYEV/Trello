package manager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WDListenerNew implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(WDListenerNew.class);

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info("before click element --> " + element.getTagName()
                +" text = "+element.getText());
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        logger.info("after click element --> " + element.getTagName());
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.error("error in method --> " + method.getName() + "exception - " + e.toString());
    }

}