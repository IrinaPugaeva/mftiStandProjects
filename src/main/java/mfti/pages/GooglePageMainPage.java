package mfti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class GooglePageMainPage extends AbstractPage<GooglePageMainPage> {

    private final String url = "/";

    public GooglePageMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='q']")
    private WebElement searchInputField;

    /**
     * Вводит текст в поле ввода поиска
     * @param text - текст
     */
    public void typeSearchText(String text) {
        searchInputField.sendKeys(text);
    }

    /**
     * Открывает страницу гугла
     * @return главная страница гугла
     */
    public GooglePageMainPage open() {
        open(url);
        return this;
    }

    /**
     * Проверяет, что главная страница гугла открыта
     * @return Главная страница гугла
     */
    @Override
    public GooglePageMainPage pageShouldBeOpened() {
        assertThat(String.format("Должна быть открыта страница %s", url),
                driver.getCurrentUrl(),
                containsString(url));
        return this;
    }
}
