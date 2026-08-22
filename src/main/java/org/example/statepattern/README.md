# State Pattern

## What is the State Pattern in Simple Terms?

Imagine an e-commerce package delivery process. A package goes through several stages:
- Ordered (Placed, but not paid)
- Paid (Processing for shipping)
- Shipped (In transit)
- Delivered (Final status)

Depending on the current status (state) of the package, the behavior of operations like `cancelOrder()` or `shipOrder()` varies:
- You can cancel an order in the "Ordered" state.
- You cannot cancel it if it has already been "Shipped".

The State Pattern allows an object to change its behavior when its internal state changes. The object will appear to change its class.

## Real-World Analogy
- An ATM: When there is money in the ATM, it dispenses cash. When it's out of cash, it rejects transaction requests and shows an out-of-cash message. The ATM behaves differently based on its state.

## Breaking It Down Like an Engineer
- **Context** (`OrderContext`): Maintains an instance of a Concrete State subclass that defines the current state.
- **State Interface** (`OrderState`): Defines a common interface for all concrete states.
- **Concrete States** (`NewState`, `PaidState`, `ShippedState`): Implement state-specific behaviors.
