import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String message = driver.findElement(By.id("message")).getText();

        if(message.equals("It's enabled!")) {
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს");
        } else {
            System.out.println("შეყვანის ველი არ გააქტიურდა და ტექსტი არ ჩანს");
        }

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"input-example\"]/button") , "Disable"));
        System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");


        WebElement inputBootcamp = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        inputBootcamp.sendKeys("Bootcamp");


        inputBootcamp.clear();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement aColumn =driver.findElement(By.id("column-a"));
        WebElement bColumn =driver.findElement(By.id("column-b"));

        aColumn.getLocation();
        bColumn.getLocation();

        if(aColumn.getLocation().getY()== bColumn.getLocation().getY()){
            System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");
        } else{
            System.out.println("სვეტები არ არიან გასწორებული");
        }

        driver.quit();
    }
}