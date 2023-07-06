package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest
{
    public void selectMenu(By by)
    {
        driver.findElement(by).click();
    }

    public void mouseHover(By by) throws InterruptedException
    {
        WebElement tab = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(tab).build().perform();
        Thread.sleep(2000);
    }
    public void send(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public void select(By by)
    {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        driver.findElement(by);
    }
    public void remove1(By by,String txt)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);


    }
}