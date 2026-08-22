package org.example.adapterpattern;

public class StripeAdapter implements Payment{

    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void pay(double amount) {
        this.stripe.PayViaStripe(amount);
    }
}
