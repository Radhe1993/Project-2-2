package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopMenuTest extends Utility
{
    @Before
    public void setUpUl()
    {
        openBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
       selectMenu(By.linkText("Desktops"));
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
       //Verify the text ‘Desktops’
        WebElement message = driver.findElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        System.out.println("message = " + message.getText());
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        Collections.sort(expected);
        Assert.assertTrue(actual.equals(expected));
        Thread.sleep(2000);

    }
   @ Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
       //mouse hover on “Laptops & Notebooks” Tab and click
       selectMenu(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
       //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
       selectMenu(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
       //Verify the text ‘Laptops & Notebooks’
       WebElement message1 = driver.findElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
       System.out.println("message = " + message1.getText());
       List<String> actual1 = new ArrayList<>();
       List<String> expected1 = new ArrayList<>();
       Collections.sort(expected1);
       Assert.assertTrue(actual1.equals(expected1));
       Thread.sleep(2000);

   }
   @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
       //Mouse hover on “Components” Tab and click
       mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));

       //call selectMenu method and pass the menu = “Show All Components”
       selectMenu(By.xpath("//a[contains(text(),'Show AllComponents')]"));

       //Verify the text ‘Components’
       WebElement message2 = driver.findElement(By.xpath("//h2[contains(text(),'Components')]"));
       System.out.println("message = " + message2.getText());
       List<String> actual2 = new ArrayList<>();
       List<String> expected2 = new ArrayList<>();
       Collections.sort(expected2);
       Assert.assertTrue(actual2.equals(expected2));
       Thread.sleep(2000);


   }
   @After
    public void close()
   {
       closeBrowser();
   }



}
