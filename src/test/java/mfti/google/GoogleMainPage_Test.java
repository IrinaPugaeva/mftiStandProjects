package mfti.google;

import mfti.data.BrowsersData;
import mfti.drivers.WebDriverFactory;
import mfti.pages.GooglePageMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Набор тестов для главной страницы гугл
 */
public class GoogleMainPage_Test {

    private WebDriver driver = null;

    /**
     * Создаем инстансу драйвера
     */
    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowsersData.Chrome);
    }

    /**
     * Закрываем браузер и убиваем сессию
     */
    @After
    public void killBrowser() {
        driver.close();
        driver.quit();
    }

    //Тест проверяет счетчик результатов поиска и выдачу самих результатов
    @Test
    public void type_text_in_search_field_check_counter() {
        new GooglePageMainPage(driver)
                //Открываем главную страницу гугл
                .open()
                .pageShouldBeOpened()
                //Вводим текст в поле поиска
                .typeSearchText("Hello World");
    }
}
