package org.example.PakingLogSystem.service;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(long charges) {
        System.out.println("Paying via Cash, Charges: " + charges);
        return true;
    }
}
