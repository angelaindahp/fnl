package com.angel.web.stepDefs;

import com.angel.web.helper.Utility;
import com.angel.web.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDef {
    LandingPage landingPage;
    FormLogin loginFormPage;
    FormContact formContact;
    AboutUsPopUp aboutUsPopUp;
    CartPage cartPage;
    FormSignUp formSignUp;
    com.angel.web.Order dataTestOrder;
    com.angel.web.PlaceOrder dataPlaceOrder;

    public LoginStepDef() {
        loginFormPage = new FormLogin();
        landingPage = new LandingPage();
        formContact = new FormContact();
        aboutUsPopUp = new AboutUsPopUp();
        dataTestOrder = new com.angel.web.Order();
        cartPage = new CartPage();
        dataPlaceOrder = new com.angel.web.PlaceOrder();
        formSignUp = new FormSignUp();
    }
    @And("user click menu Log in")
    public void navigateToLoginForm() throws InterruptedException {
        landingPage.menuLoginClicked();
        Thread.sleep(1000);
    }

    @When("user input username {string}")
    public void entryUsernameField(String username) throws InterruptedException {
        loginFormPage.fillUsername(username);
        Thread.sleep(1000);
    }

    @And("user input password {string}")
    public void entryPasswordField(String password) throws InterruptedException {
        loginFormPage.fillPassword(password);
        Thread.sleep(1000);
    }

    @And("user click login button")
    public void clickButtonLogin() throws InterruptedException {
        loginFormPage.buttonLoginClicked();
        Thread.sleep(1000);
    }

    @Then("User login successfully with welcome message {string}")
    public void loginSuccessfully(String welcomeMessege) throws InterruptedException {
        landingPage.verifyLoginSuccessfull(welcomeMessege);
        Thread.sleep(1000);
    }


    /****************************** Step for Log out Operation  *********************/
    @And("User has been logged in")
    public void userHasBeenLoggedIn() throws InterruptedException {
        navigateToLoginForm(); // user click menu Log in
        entryUsernameField("joross123"); // user input username "joross123"
        entryPasswordField("Test123"); // user input password "Test123"
        clickButtonLogin(); // u
    }

    @When("User click menu Log out")
    public void userClickMenuLogOut() throws InterruptedException {
        landingPage.menuLogoutClicked();
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='card-img-top img-fluid'])[1]")));
        Thread.sleep(1000);
    }

    @Then("User Log out Successfully and display menu {string}")
    public void serSuccessfullyLogOut(String menuSignUp) throws InterruptedException {
        landingPage.verifyLogOutSuccessfully(menuSignUp);
        Thread.sleep(1000);
    }
}
