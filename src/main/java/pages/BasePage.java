package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected  static WebDriver driver;

    public  static  void  setDriver(WebDriver driver){
        BasePage.driver=driver;
    }

    public  void pause(int time){
        try{
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
           throw  new RuntimeException(e);
        }
    }
}
