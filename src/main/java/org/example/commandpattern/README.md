# Command Pattern

## What is the Command Pattern in Simple Terms?

Imagine you buy a smart remote control. The remote has buttons, but the remote does not know what devices are connected to it, nor does it know how to turn them on or off. 

Instead of hardcoding the remote to call `light.turnOn()` directly, you encapsulate that action into a `Command` object. The remote just calls `execute()` on the command. 

This decouples the object that triggers the action (the remote) from the object that knows how to perform it (the light). It also makes it easy to support features like **undo/redo** or request queuing.

## Real-World Analogy
- A Restaurant: A waiter takes your order (Command) and writes it on a piece of paper. The waiter gives the order to the kitchen (Receiver). The waiter doesn't know how to cook the food, and the chef doesn't know who ordered it. The slip of paper encapsulates the request.

## Breaking It Down Like an Engineer
- **Command Interface** (`Command`): Declares an interface for executing operations.
- **Concrete Command** (`LightOnCommand`): Defines a binding between a Receiver object and an action.
- **Client**: Creates a Concrete Command object and sets its Receiver.
- **Invoker** (`RemoteControl`): Asks the command to carry out the request.
- **Receiver** (`Light`): Knows how to perform the operations associated with carrying out a request.
