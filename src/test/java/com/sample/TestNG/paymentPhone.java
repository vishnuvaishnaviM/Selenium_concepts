package com.sample.TestNG;
//grouping concept
//class1
import org.testng.annotations.Test;

public class paymentPhone {
    @Test
    public void loginByEmail() {
        System.out.println("Logged in through email");
    }

    @Test
    public void paymentWebsite() {
        System.out.println("Paid through website");
    }

    @Test
    public void paymentATM() {
        System.out.println("Paid through ATM");
    }
}
