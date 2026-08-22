# Adapter Pattern

## What is the Adapter Pattern?

The **Adapter Pattern** is a structural design pattern that allows two incompatible interfaces to work together.

It acts like a **bridge or translator** between an existing class and the interface that the client expects.

---

# Real-World Scenario: Power Adapter

Imagine you have a laptop with a **US-style plug**, but the wall socket uses a **different type of plug**.

The laptop cannot connect directly to the socket.

So, you use a **power adapter**:

```text
Laptop
  ↓
US Plug
  ↓
Power Adapter
  ↓
Wall Socket
```

The adapter converts the interface that the laptop provides into the interface that the wall socket expects.

---

# Example: Payment System

Imagine our application expects all payment services to use:

```java
pay(double amount)
```

But an existing payment service has a different method:

```java
makePayment(double amount)
```

We don't want to modify the existing payment service.

Instead, we create an **Adapter**.

---

# 1. Target Interface

This is the interface our application expects.

```java
public interface Payment {

    void pay(double amount);
}
```

---

# 2. Existing Class

This is an existing class with an incompatible interface.

```java
public class PayPal {

    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}
```

Notice that `PayPal` has:

```java
makePayment()
```

instead of:

```java
pay()
```

---

# 3. Adapter

The adapter implements the interface that our application expects and internally uses the existing class.

```java
public class PayPalAdapter implements Payment {

    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(double amount) {
        payPal.makePayment(amount);
    }
}
```

The adapter translates:

```text
pay()
 ↓
makePayment()
```

---

# 4. Client (This is optional)

The client only depends on the `Payment` interface.

```java
public class PaymentService {

    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}
```

The client doesn't need to know that PayPal uses a different method.

---

# 5. Using the Adapter

```java
public class Main {

    public static void main(String[] args) {

        PayPal payPal = new PayPal();

        Payment payment = new PayPalAdapter(payPal);

        PaymentService service = new PaymentService();

        service.processPayment(payment, 100);
        
        // Or if you didnt create the service, you can simply try
        // payment.pay(100)
    }
}
```

Output:

```text
Paid $100.0 using PayPal.
```

---

# How It Works

The flow is:

```text
PaymentService (optional)
      ↓
Payment Interface
      ↓
PayPalAdapter
      ↓
PayPal
      ↓
makePayment()
```

The client calls:

```java
payment.pay(100);
```

The adapter converts that call into:

```java
payPal.makePayment(100);
```

---

# Key Idea

> **The Adapter Pattern allows incompatible classes to work together without modifying their existing code.**

The **Adapter** acts as a translator between two interfaces.

```text
Client
  ↓
Expected Interface
  ↓
Adapter
  ↓
Existing Class
```

This is especially useful when integrating **legacy code, third-party libraries, or external APIs** that don't match the interface used by your application.
