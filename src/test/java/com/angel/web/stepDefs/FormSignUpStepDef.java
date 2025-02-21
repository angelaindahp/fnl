package com.angel.web.stepDefs;

import com.angel.web.helper.Utility;
import com.angel.web.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormSignUpStepDef {
    LandingPage landingPage;
    FormLogin loginFormPage;
    FormContact formContact;
    AboutUsPopUp aboutUsPopUp;
    CartPage cartPage;
    FormSignUp formSignUp;
    com.angel.web.Order dataTestOrder;
    com.angel.web.PlaceOrder dataPlaceOrder;

    public FormSignUpStepDef(){
        loginFormPage = new FormLogin();
        landingPage = new LandingPage();
        formContact = new FormContact();
        aboutUsPopUp = new AboutUsPopUp();
        dataTestOrder = new com.angel.web.Order();
        cartPage = new CartPage();
        dataPlaceOrder = new com.angel.web.PlaceOrder();
        formSignUp = new FormSignUp();
    }



    @Given("user go to Product Store page {string}")
    public void navigateToWebApp(String url) throws InterruptedException {
        Utility.openPage(url); // navigate to url website
        Thread.sleep(1000);
    }

    @And("user click menu Sign up")
    public void userClickMenuSignUp() throws InterruptedException {
        landingPage.menuSignupClicked();
        Thread.sleep(1000);
    }

    @When("user input sign up username and password with valid data")
    public void userInputSignUpUsernameAndPasswordWithValidData() throws InterruptedException {
        String username = Utility.generateRandomData();
        String password = Utility.generateRandomData();

        formSignUp.fillUsername(username);
        Thread.sleep(1000);
        formSignUp.fillPassword(password);
        Thread.sleep(1000);
    }

    @And("user click sign up button")
    public void userClickSignUpButton() throws InterruptedException {
        formSignUp.buttonSignUpClicked();
        Thread.sleep(1000);
    }

    @Then("Sign up successfully and display message {string}")
    public void signUpSuccessfullyAndDisplayMessage(String messege) throws InterruptedException {
        landingPage.verifyAllertMessage(messege);
        Thread.sleep(1000);
        Utility.getDriver().switchTo().alert().accept();
        // wait for the new page to load
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='card-img-top img-fluid'])[1]")));
        Thread.sleep(1000);
    }


    /****************************** Step for Operation for Sign Up *********************/
    @When("user input sign up username {string}")
    public void userInputSignUpUsername(String username) throws InterruptedException {
        formSignUp.fillUsername(username);
        Thread.sleep(1000);
    }

    @And("user input sign up password {string}")
    public void userInputSignUpPassword(String password) throws InterruptedException {
        formSignUp.fillPassword(password);
        Thread.sleep(1000);
    }
}