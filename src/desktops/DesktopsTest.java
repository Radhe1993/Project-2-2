package desktops;

import homepage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    @Before
    public void setUpurl() {
        openBrowser();
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Mouse hover on Desktops Tab.and click
        mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(2000);

        // Select Sort By position "Name: Z to A"
        selectMenu(By.xpath("//option[contains(text(),'Name (Z - A)')]"));
        Thread.sleep(2000);

        //  Verify the Product will arrange in Descending order
        List<WebElement> web = driver.findElements(By.xpath("//h4/a"));
        System.out.println("Total product are = " + web.size());

        for (WebElement product : web) {
            String result = product.getText();
            String actual = result;
            String expectsd = result;
            System.out.println("Total Products are = " + actual.toLowerCase());
            Assert.assertEquals("message", actual, expectsd);

        }


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Mouse hover on Desktops Tab.and click
        mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        selectMenu(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(2000);

        //Select Sort By position "Name: A to Z"
        selectMenu(By.xpath("//option[contains(text(),'Name (A - Z)')]"));

        //Select product “HP LP3065”
        selectMenu(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[3]/div[1]"));

        //2.5 Verify the Text "HP LP3065"

        //2.6 Select Delivery Date "2022-11-30
        WebElement message2 = driver.findElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        System.out.println("message = " + message2.getText());
        List<String> actual2 = new ArrayList<>();
        List<String> expected2 = new ArrayList<>();
        Collections.sort(expected2);
        Assert.assertTrue(actual2.equals(expected2));
        Thread.sleep(2000);


        //2.6 Select Delivery Date "2022-11-30
        String year = "2023";
        String month = "November";
        String date = "30";
        selectMenu(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                selectMenu(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
           Thread.sleep(2000);
            //2.7.Enter Qty "1” using Select class.
            remove1(By.xpath("//input[@id='input-quantity']"),"1");
           Thread.sleep(2000);

            //2.8 Click on “Add to Cart” button
            selectMenu(By.xpath("//button[@id='button-cart']"));
            //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        WebElement message3 = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        System.out.println("message = " + message3.getText());
        List<String> actual3 = new ArrayList<>();
        List<String> expected3 = new ArrayList<>();
        Collections.sort(expected3);
        Assert.assertTrue(actual3.equals(expected3));
        Thread.sleep(2000);
       // Click on link “shopping cart” display into success message
        selectMenu(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(2000);
        //Verify the text "Shopping Cart"
        WebElement message4 = driver.findElement(By.xpath("//div[@id='content']//h1"));
        Thread.sleep(2000);
        System.out.println("message = " + message4.getText());
        List<String> actual4 = new ArrayList<>();
        List<String> expected4 = new ArrayList<>();
        Collections.sort(expected4);
        Assert.assertTrue(actual4.equals(expected4));
        Thread.sleep(2000);

        //Verify the Product name "HP LP3065"
        WebElement message5 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a"));
        System.out.println("message = " + message5.getText());
        List<String> actual5 = new ArrayList<>();
        List<String> expected5 = new ArrayList<>();
        Collections.sort(expected4);
        Assert.assertTrue(actual5.equals(expected5));
        Thread.sleep(2000);

        //2.13 Verify the Delivery Date "2022-11-30
        WebElement message6 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]"));
        System.out.println("message = " + message6.getText());
        List<String> actual6 = new ArrayList<>();
        List<String> expected6 = new ArrayList<>();
        Collections.sort(expected6);
        Assert.assertTrue(actual6.equals(expected6));
        Thread.sleep(2000);

        //11-30"
        //2.14 Verify the Model "Product21"
        WebElement message7 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]"));
        System.out.println("message = " + message7.getText());
        List<String> actual7 = new ArrayList<>();
        List<String> expected7 = new ArrayList<>();
        Collections.sort(expected7);
        Assert.assertTrue(actual7.equals(expected7));
        Thread.sleep(2000);

        //Verify the Todat "£74.73"
        WebElement message8 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"));
        System.out.println("message = " + message8.getText());
        List<String> actual8 = new ArrayList<>();
        List<String> expected8 = new ArrayList<>();
        Collections.sort(expected8);
        Assert.assertTrue(actual8.equals(expected8));
        Thread.sleep(2000);


    }
    @After
    public void close()
    {
        closeBrowser();
    }



}






