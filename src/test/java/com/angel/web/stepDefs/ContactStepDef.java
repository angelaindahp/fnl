package com.angel.web.stepDefs;

import com.angel.web.Order;
import com.angel.web.PlaceOrder;
import com.angel.web.helper.Utility;
import com.angel.web.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactStepDef {
    LandingPage landingPage;
    FormLogin loginFormPage;
    FormContact formContact;
    AboutUsPopUp aboutUsPopUp;
    CartPage cartPage;
    FormSignUp formSignUp;
    Order dataTestOrder;
    PlaceOrder dataPlaceOrder;

    public ContactStepDef() {
        loginFormPage = new FormLogin();
        landingPage = new LandingPage();
        formContact = new FormContact();
        aboutUsPopUp = new AboutUsPopUp();
        dataTestOrder = new Order();
        cartPage = new CartPage();
        dataPlaceOrder = new PlaceOrder();
        formSignUp = new FormSignUp();
    }
    @And("user click menu Contact")
    public void userClickMenuContact() throws InterruptedException {
        landingPage.menuContactClicked();
        Thread.sleep(1000);
    }

    @When("user input Contact Email {string}")
    public void userInputContactEmail(String contactEmail) throws InterruptedException {
        formContact.fillContactEmail(contactEmail);
        Thread.sleep(1000);
    }

    @And("user input Contact Name {string}")
    public void userInputContactName(String contactName) throws InterruptedException {
        formContact.fillContactName(contactName);
        Thread.sleep(1000);
    }

    @And("user input Message {string}")
    public void userInputMessage(String message) throws InterruptedException {
        formContact.fillMessage(message);
        Thread.sleep(1000);
    }

    @And("user click button Send Message")
    public void userClickButtonSendMessage() throws InterruptedException {
        formContact.buttonSendMessageClicked();
        Thread.sleep(3000);
    }

    @Then("Send Message successfully and display message {string}")
    public void sendMessageSuccessfullyAndDisplayMessage(String messege) throws InterruptedException {
        landingPage.verifyAllertMessage(messege);
        Thread.sleep(2000);
        Utility.getDriver().switchTo().alert().accept();

        // wait for the new page to load
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='card-img-top img-fluid'])[1]")));
        Thread.sleep(1000);
    }
}
