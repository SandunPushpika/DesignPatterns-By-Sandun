package org.example.adapterpattern;

public class AdapterPattern {
    public static void main(String[] args) {
        Payment stripePayment = new StripeAdapter(new Stripe());
        Payment payPalPayment = new PaypalAdapter(new PayPal());

        stripePayment.pay(200);
        payPalPayment.pay(200);
    }
}
