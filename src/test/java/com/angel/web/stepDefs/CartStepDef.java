package com.angel.web.stepDefs;

import com.angel.web.ItemProduct;
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

public class CartStepDef {
    LandingPage landingPage;
    FormLogin loginFormPage;
    FormContact formContact;
    AboutUsPopUp aboutUsPopUp;
    CartPage cartPage;
    FormSignUp formSignUp;
    Order dataTestOrder;
    PlaceOrder dataPlaceOrder;

    public CartStepDef() {
        loginFormPage = new FormLogin();
        landingPage = new LandingPage();
        formContact = new FormContact();
        aboutUsPopUp = new AboutUsPopUp();
        dataTestOrder = new Order();
        cartPage = new CartPage();
        dataPlaceOrder = new PlaceOrder();
        formSignUp = new FormSignUp();
    }

    @When("user order product item {string}")
    public void userChoosedProductItem(String nameProduct) throws InterruptedException {
        landingPage.itemProductClicked(nameProduct);
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-success.btn-lg")));
    }

    @And("User click Add to chart")
    public void userClickAddToChart() throws InterruptedException {
        landingPage.buttonAddToCartClicked();
        Thread.sleep(1000);
    }

    @Then("user should be able see message {string}")
    public void userShouldBeAbleSeeMessage(String message) throws InterruptedException {
        landingPage.verifyAllertMessage(message);
        Thread.sleep(2000);
        Utility.getDriver().switchTo().alert().accept();

        // get data order to Data Test
        ItemProduct product = landingPage.getInformationItemOrder();
        dataTestOrder.addItemProductOrder(product);
    }

    @And("user should be able see product ordered in the Cart Page")
    public void userShouldBeAbleSeeProductOrderedInTheCartPage() throws InterruptedException {
        /* Langkah Verifikasi
         *  1. Buka Cart Menu
         *  2. Get detail product, then verify value of title, price, total price
         */
        landingPage.menuCartClicked();
        //wait until Product displayed
        String nameProduct = dataTestOrder.getDataOrdered().get(0).getName();
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(Utility.getDriver().findElement(By.xpath("//div[@id='page-wrapper']")), nameProduct));
        cartPage.verifyAddItemToCartPageSuccessfully(dataTestOrder);
        Thread.sleep(1000);
    }








    /****************************** Step for Operation in Order Page *********************/
    @And("user already ordered Item")
    public void userAlreadyOrderedItem() throws InterruptedException {
        System.out.println("Step to ordered");
        // step ordered : please code detail
        // use Landing Page to web locator and action add to cart

        /* langkah order 2 product
            1. klik product Samsung Galaxy s6
            2. klik tombol Add to cart
            3. klik menu home
            4. klik kategori monitor
            5. klik asus Full HD
            6. klik tombol Add to cart
        */
        userChoosedProductItem("Samsung galaxy s6");
        userClickAddToChart();
        Thread.sleep(2000);
        userShouldBeAbleSeeMessage("Product added");
        landingPage.menuHomeClicked();
        Thread.sleep(1000);
        landingPage.categoryMonitorsClicked();
        Thread.sleep(1000);
        userChoosedProductItem("ASUS Full HD");
        userClickAddToChart();
        Thread.sleep(2000);
        userShouldBeAbleSeeMessage("Product added");

        dataTestOrder.calculateTotalPrice();
        System.out.println("Total Price: " + dataTestOrder.getTotalPrice());
        Thread.sleep(1000);
    }

    @And("user click menu Cart")
    public void userClickMenuCart() throws InterruptedException {
        landingPage.menuCartClicked();
        Thread.sleep(1000);
    }

    @When("user click button Place Order")
    public void userClickButtonPlaceOrder() throws InterruptedException {
        cartPage.buttonPlacerOrderClicked();
        Thread.sleep(1000);
    }

    @And("user input Name {string}")
    public void userInputName(String name) throws InterruptedException {
        cartPage.fillName(name);
        dataPlaceOrder.setName(name);
        Thread.sleep(1000);
    }

    @And("user input Country {string}")
    public void userInputCountry(String country) throws InterruptedException {
        cartPage.fillCountry(country);
        dataPlaceOrder.setCountry(country);
        Thread.sleep(1000);
    }

    @And("user input City {string}")
    public void userInputCity(String city) throws InterruptedException {
        cartPage.fillCity(city);
        dataPlaceOrder.setCity(city);
        Thread.sleep(1000);
    }

    @And("user input Credit Card {string}")
    public void userInputCreditCard(String creditCard) throws InterruptedException {
        cartPage.fillCreditCard(creditCard);
        dataPlaceOrder.setCreditCard(creditCard);
        Thread.sleep(1000);
    }

    @And("user input Month {string}")
    public void userInputMonth(String month) throws InterruptedException {
        cartPage.fillMonth(month);
        dataPlaceOrder.setMonth(month);
        Thread.sleep(1000);
    }

    @And("user input Year {string}")
    public void userInputYear(String year) throws InterruptedException {
        cartPage.fillYear(year);
        dataPlaceOrder.setYear(year);
        Thread.sleep(1000);
    }

    @And("user click button Purchase")
    public void userClickButtonPurchase() throws InterruptedException {
        cartPage.buttonPurchasedClicked();
        Thread.sleep(1000);
    }

    @Then("Order process successfully")
    public void orderProcessSuccessfully() throws InterruptedException {
        cartPage.verifyOrderSuccessfully(dataTestOrder.getTotalPrice(), dataPlaceOrder.getName(), dataPlaceOrder.getCreditCard());
        Thread.sleep(1000);
    }


}