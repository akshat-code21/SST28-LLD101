package com.example.payments;

public class FastPayAdapter implements PaymentGateway{
    private final FastPayClient fpc;
    public FastPayAdapter(FastPayClient fpc){
        this.fpc = fpc;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        return fpc.payNow(customerId,amountCents);
    }
}
