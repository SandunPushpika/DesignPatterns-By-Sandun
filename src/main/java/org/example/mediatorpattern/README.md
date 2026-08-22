# Mediator Pattern

## What is the Mediator Pattern in Simple Terms?

Imagine you are at an airport. There are dozens of airplanes flying, landing, and taking off. If pilots had to communicate directly with every other pilot to coordinate their flight paths, the system would be chaotic and highly error-prone. 

Instead, every pilot communicates with the **Air Traffic Control tower** (the Mediator). The tower receives all reports, updates flight schedules, and coordinates paths without airplanes having to interact with each other directly.

The Mediator Pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, and lets you vary their interaction independently.

## Real-World Analogy
- Chat Room: When users join a chat room, they send messages to the server (Mediator), which relays the messages to all other users in the chat. Users don't need to have direct connections to each other.

## Breaking It Down Like an Engineer
- **Mediator Interface** (`ChatMediator`): Defines an interface for communicating with Colleague objects.
- **Concrete Mediator** (`ChatMediatorImpl`): Implements cooperative behavior by coordinating Colleague objects.
- **Colleague Classes** (`User`, `UserImpl`): Each Colleague class knows its Mediator object, and communicates with its mediator whenever it would have otherwise communicated with another colleague.
