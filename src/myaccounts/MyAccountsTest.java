package myaccounts;

import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountsTest extends Utility
{
    @Before
    public void setUpUl()
    {
        openBrowser();
    }
  /*  @Test
    public void selectMyAccountOptions(String option)
    {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

    }*/
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));
        selectMenu(By.xpath("//a[contains(text(),'Register')]"));
        ////h1[contains(text(),'Register Account')]
        //Verify the text “Register Account”.
        WebElement txt = driver.findElement(By.xpath("//div[@id='content']//h1"));
        String actual = txt.getText();
        String expected = txt.getText();
        System.out.println("message = "+actual);
        Assert.assertEquals("message",actual,expected);
        Thread.sleep(2000);



    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));
        selectMenu(By.xpath("//a[contains(text(),'Login')]"));

        //Verify the text “Returning Customer”.
        WebElement txt = driver.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        String actual = txt.getText();
        String expected = txt.getText();
        System.out.println("message = "+actual);
        Assert.assertEquals("message",actual,expected);
        Thread.sleep(2000);



    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));
        selectMenu(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(2000);

        //Enter First Name
        send(By.xpath("//input[@id='input-firstname']"),"Sita");
        send(By.xpath("//input[@id='input-lastname']"),"Ram");
        send(By.xpath("//input[@id='input-email']"),"prime@gmail.com ");
        send(By.xpath("//input[@id='input-telephone']"),"8899977665");
        send(By.xpath("//input[@id='input-password']"),"prime@123");
        send(By.xpath("//input[@id='input-confirm']"),"prime@123");

        //Select Subscribe Yes radio button
        selectMenu(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        Thread.sleep(2000);

        //Click on Privacy Policy check box
        selectMenu(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

        //Click on Continue button
        selectMenu(By.xpath("//input[@value='Continue']"));
        Thread.sleep(2000);

        //Verify the message “Your Account Has Been Created!”
        WebElement txt = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actual = txt.getText();
        String expected = txt.getText();
        System.out.println("message = "+actual);
        Assert.assertEquals("message",actual,expected);
        Thread.sleep(2000);

        //Click on Continue button
        selectMenu(By.linkText("Continue"));

        //Click on My Account Link.
        //Click on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));
        selectMenu(By.linkText("Logout"));

        //Verify the text “Account Logout”
        WebElement txt1 = driver.findElement(By.linkText("Logout"));
        String actual1 = txt1.getText();
        String expected1 = txt1.getText();
        System.out.println("message = "+actual1);
        Assert.assertEquals("message",actual1,expected1);
        Thread.sleep(2000);

        //Click on Continue button
        selectMenu(By.linkText("Continue"));




    }
    @Test
     public void  verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //Click on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));
        selectMenu(By.xpath("//a[contains(text(),'Login')]"));

        //Enter Email address
        send(By.xpath("//input[@id='input-email']"),"prime@gmail.com ");
        //Enter Password
        send(By.xpath("//input[@id='input-password']"),"prime@123");
        //Click on Login button
        selectMenu(By.xpath("//input[@value='Login']"));
        Thread.sleep(2000);

        //Verify text “My Account”
        WebElement txt1 = driver.findElement(By.linkText("My Account"));
        String actual1 = txt1.getText();
        String expected1 = txt1.getText();
        System.out.println("message = "+actual1);
        Assert.assertEquals("message",actual1,expected1);
        Thread.sleep(2000);

        //Clickr on My Account Link.
        selectMenu(By.xpath("//span[contains(text(),'My Account')]"));

        //Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
      //  WebElement txt2 = driver.findElement(By.linkText("Account Logout"));
        selectMenu(By.linkText("Logout"));
        Thread.sleep(2000);

        //Verify the text “Account Logout”
        WebElement txt3 = driver.findElement(By.linkText("Logout"));
        String actual3 = txt3.getText();
        String expected3 = txt3.getText();
        System.out.println("message = "+actual3);
        Assert.assertEquals("message",actual3,expected3);
        Thread.sleep(2000);

        //Click on Continue button
        selectMenu(By.linkText("Continue"));





    }

}
