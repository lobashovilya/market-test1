import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Илья\\IdeaProjects\\TestProject\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Илья\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            webDriver.get("https://www.ya.ru/");
            webDriver.findElement(By.xpath("//input[@class='search3__input mini-suggest__input']")).sendKeys("Yamarket");
            webDriver.findElement(By.xpath("//nav//a[@class='home-link2 services-suggest__item services-suggest__item_search_yes home-link2_color_black home-link2_hover_secondary']")).click();
            for (String tab : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(tab);
            }
            webDriver.findElement(By.xpath("//button[@class='V9Xu6 button-focus-ring _1KI8u Lfy7z _3iB1w _35Vhw']")).click();
            webDriver.findElement(By.xpath("//div[@class='_1dWFG']//a[text()='Смартфоны']")).click();
            for (String tab : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(tab);
            }
            webDriver.findElement(By.xpath("//input[@class='_3qxDp _1R_cW']")).sendKeys("20000");
            webDriver.findElement(By.xpath("//button[@class='_1KpjX _32hAj']")).click();
            webDriver.findElement(By.xpath("//span[text()='Samsung']/../span[@class='_2XaWK']")).click();
            webDriver.findElement(By.xpath("//span[text()='BQ']/../span[@class='_2XaWK']")).click();
            webDriver.findElement(By.xpath("//span[text()='Nokia']/../span[@class='_2XaWK']")).click();
            webDriver.findElement(By.xpath("//span[text()='ZTE']/../span[@class='_2XaWK']")).click();
            webDriver.findElement(By.xpath("//span[text()='AGM']/../span[@class='_2XaWK']")).click();
            webDriver.findElement(By.xpath("//span[text()='до 3.4\"']/../span[@class='_2XaWK']")).click();
            for (String tab : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(tab);
            }
            List<WebElement> phones = webDriver.findElements(By.xpath("//div[@data-test-id='virtuoso-item-list']//div[@class='_1GfBD']//a"));
            webDriver.findElement(By.xpath("//button[text()='по цене']")).click();
            phones.get(0).click();
            System.out.println(webDriver.findElement(By.xpath("//div[@class='_3driS']//div[@class='cXkP_ _3wss4 _1h5x- _1q_73']/span")).getText());
            webDriver.quit();
        }
        catch (Exception e)
        {
            System.out.println(e);
            webDriver.quit();
        }
    }
}