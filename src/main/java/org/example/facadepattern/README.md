# Facade Pattern

## What is the Facade Pattern in Simple Terms?

Imagine you have a complex home theater setup. It consists of a DVD Player, a Projector, a Sound System, and an Amplifier. When you want to watch a movie, you have to do multiple steps:
1. Turn on the projector.
2. Set the projector to widescreen mode.
3. Turn on the amplifier.
4. Set the amplifier input to DVD.
5. Set the amplifier volume.
6. Turn on the sound system.

Doing this every time is tedious. Instead, you create a unified control remote that exposes a single button: `watchMovie()`. Under the hood, this button invokes all the individual components in the correct order.

The Facade Pattern provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

## Real-World Analogy
- Customer Service: When you call a business, you speak with a receptionist (Facade). You don't call the billing department, shipping department, and tech support directly. The receptionist handles directing your request to the internal systems.

## Breaking It Down Like an Engineer
- **Facade** (`HomeTheaterFacade`): Delegates client requests to appropriate subsystem objects. It knows which subsystem classes are responsible for a request.
- **Subsystem Classes** (`Amplifier`, `Projector`, `SoundSystem`): Implement subsystem functionality. They have no knowledge of the facade.
