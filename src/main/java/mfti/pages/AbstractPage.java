package mfti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base Page Pattern
 * @param <T>
 */
public abstract class AbstractPage<T> {

    protected WebDriver driver = null;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Открывает страницу
     * @param url - относительный URL страницы
     * @return инстанса страницы
     */
    protected T open(String url) {
        driver.get(System.getProperty("webdriver.base.url") + url);
        return (T) this;
    }

    protected abstract T pageShouldBeOpened();
}
