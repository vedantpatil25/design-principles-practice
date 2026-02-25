package org.example.PakingLogSystem.service;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(long charges) {
        System.out.println("Paying via CreditCard, Charges: " + charges);
        return true;
    }
}
