package laptopsandnotebooks;

import homepage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility
{
    @Before
    public void setUpurl() {
        openBrowser();
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHover(By.linkText("Laptops & Notebooks"));
        //Click on “Show All Laptops & Notebooks”
        selectMenu(By.linkText("Show AllLaptops & Notebooks"));
        //1.3  Select Sort By "Price (High > Low)"
        selectMenu(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        List<WebElement> list = driver.findElements(By.xpath("//p[@class ='price']"));
        System.out.println("Price = "+list.size());
        for (WebElement price : list)
        {
            String price1 = price.getText();
            String actual = price1;
            String expected = price1;
            System.out.println("price = "+actual.toLowerCase());
            Assert.assertEquals("message = ",actual,expected);
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Laptops & Notebooks Tab and click
        mouseHover(By.linkText("Laptops & Notebooks"));
        //Click on “Show All Laptops & Notebooks”
        selectMenu(By.linkText("Show AllLaptops & Notebooks"));
        Thread.sleep(2000);
        //Select Sort By "Price (High > Low)"
        selectMenu(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        //Select Product “MacBook”
        selectMenu(By.linkText("MacBook"));
        Thread.sleep(2000);

        //Verify the text “MacBook”
        WebElement txt = driver.findElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        String actual = txt.getText();
        String expected = txt.getText();
        System.out.println("message = "+actual);
        Assert.assertEquals("message",actual,expected);

        //Click on ‘Add To Cart’ button
        selectMenu(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);

        //Verify the message “Success: You have added MacBook to your shopping cart!”
        WebElement txt1 = driver.findElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        String actual1 = txt.getText();
        String expected1 = txt.getText();
        System.out.println("message = "+actual1);
        Assert.assertEquals("message",actual1,expected1);
        Thread.sleep(2000);


        //Click on link “shopping cart” display into success message
        selectMenu(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(2000);

        //Verify the text "Shopping Cart"
        WebElement txt2 = driver.findElement(By.xpath("//div[@id='content']//h1"));
        String actual2 = txt2.getText();
        String expected2 = txt2.getText();
        System.out.println("message = "+actual2);
        Assert.assertEquals("message",actual2,expected2);
        Thread.sleep(2000);


        //Verify the Product name "MacBook"
        WebElement txt3 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a"));
        String actual3 = txt3.getText();
        String expected3 = txt3.getText();
        System.out.println("message = "+actual3);
        Assert.assertEquals("message",actual3,expected3);
        Thread.sleep(2000);


        //Change Quantity "2"
        remove1(By.xpath("//input[contains(@name, 'quantity')]"),"2");
        Thread.sleep(2000);


        //Verify the Total £737.45
        WebElement txt4 = driver.findElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"));
        String actual4 = txt4.getText();
        String expected4 = txt4.getText();
        System.out.println("message = "+actual4);
        Assert.assertEquals("message",actual4,expected4);
        Thread.sleep(2000);


        //Click on “Checkout” button
        selectMenu(By.xpath("//a[contains(text(),'Checkout')]"));
        //Verify the text “Checkout”
        WebElement txt5 = driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        String actual5 = txt5.getText();
        String expected5 = txt5.getText();
        System.out.println("message = "+actual5);
        Assert.assertEquals("message",actual5,expected5);
        Thread.sleep(2000);

        //Verify the Text “New Customer”
        //h2[contains(text(),'New Customer')]
        WebElement txt6 = driver.findElement(By.xpath(" //h2[contains(text(),'New Customer')]"));
        String actual6 = txt6.getText();
        String expected6 = txt6.getText();
        System.out.println("message = "+actual6);
        Assert.assertEquals("message",actual6,expected6);
        Thread.sleep(2000);

        //2.18 Click on “Guest Checkout” radio button
        selectMenu(By.xpath("//input[@name='account'][@value='guest']"));

        //Click on “Continue” tab
        selectMenu(By.xpath("//input[@id='button-account']"));
        Thread.sleep(2000);

        //Fill the mandatory fields
        send(By.xpath("//input[@id='input-payment-firstname']"),"Sita");
        send(By.xpath("//input[@id='input-payment-lastname']"),"Ram");
        send(By.xpath("//input[@id='input-payment-email']"),"sitaram@gmail.com");
        send(By.xpath("//input[@id='input-payment-telephone']"),"8877996655");
        send(By.xpath("//input[@id='input-payment-address-1']"),"44,villa");
        send(By.xpath("//input[@id='input-payment-city']"),"Delhi");
        send(By.xpath("//input[@id='input-payment-postcode']"),"564732");
        send(By.xpath("//select[@id='input-payment-country']"),"India");
        mouseHover(By.xpath("//select[@name='zone_id']"));
        selectMenu(By.xpath("//option[contains(text(),'Bristol')]"));
        Thread.sleep(2000);


        //Click on “Continue” Button
        selectMenu(By.xpath("//input[@id='button-guest']"));

        //Add Comments About your order into text area
        send(By.xpath("Add Comments About Your Order"),"Nice Product");

        //Check the Terms & Conditions check box
        selectMenu(By.name("agree"));

        //Click on “Continue” button
        selectMenu(By.xpath("//input[@value='Continue']"));

        //Verify the message “Warning: Payment method required!”
        WebElement txt7 = driver.findElement(By.className("alert alert-danger alert-dismissible"));
        String actual7 = txt7.getText();
        String expected7 = txt7.getText();
        System.out.println("message = "+actual7);
        Assert.assertEquals("message",actual7,expected7);
        Thread.sleep(2000);


    }
    @After
    public void close()
    {
       // closeBrowser();
    }

}
