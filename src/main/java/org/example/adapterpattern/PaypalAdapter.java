package org.example.adapterpattern;

public class PaypalAdapter implements Payment{
    private PayPal payPal;

    public PaypalAdapter(PayPal payPal){
        this.payPal = payPal;
    }

    @Override
    public void pay(double amount) {
        payPal.PayViaPayPal(amount);
    }
}
