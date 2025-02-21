package com.angel.web.stepDefs;

import com.angel.web.Order;
import com.angel.web.PlaceOrder;
import com.angel.web.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AboutUsStepDef {
    LandingPage landingPage;
    FormLogin loginFormPage;
    FormContact formContact;
    AboutUsPopUp aboutUsPopUp;
    CartPage cartPage;
    FormSignUp formSignUp;
    Order dataTestOrder;
    PlaceOrder dataPlaceOrder;

    public AboutUsStepDef() {
        loginFormPage = new FormLogin();
        landingPage = new LandingPage();
        formContact = new FormContact();
        aboutUsPopUp = new AboutUsPopUp();
        dataTestOrder = new Order();
        cartPage = new CartPage();
        dataPlaceOrder = new PlaceOrder();
        formSignUp = new FormSignUp();
    }


    @And("user click menu About Us")
    public void userClickMenuAboutUs() throws InterruptedException {
        landingPage.menuAboutUsClicked();
        Thread.sleep(1000);
    }

    @When("user click button video")
    public void userClickButtonVideo() throws InterruptedException {
        aboutUsPopUp.videoClicked();
        Thread.sleep(1000);
    }

    @Then("Video played successfully")
    public void videoPlayedSuccessfully() throws InterruptedException {
        aboutUsPopUp.verifyVideoAlreadyPlaySuccessfully();
        Thread.sleep(1000);
    }
}
