# The Observer Pattern

## What is Observer Pattern in Simple Terms?

- Think there is a person **Bobby**, he finds job vacancies for people.
- There is **Ally**, she needs a job and she doesn't know where to find a job from.
- And there is **Jack**, He also needs a job so.

Both comes to Bobby. And here is the conversation,

- **Ally**: Hey Bobby. I am looking for a Software Engineering job. Do you have any?
- **Bobby**: Not at the moment, But I will add you to the list. And I will inform you when there is a job suitable for you.
- **Ally**: Thanks Bobby!

- **Jack**: I've got 2 years of experience in Java development. Do you have any jobs?
- **Bobby**: Nope, I will add you to the list and inform you when there is a vacancy.

- **Ally**: Hey Bobby, You dont need to find me jobs. I've found a one for me.
- **Bobby**: Sure I will kick you out of the list.

So here, you can see Bobby is like a **publisher** and Ally and Jack were like **subscribers** to Bobby. When Bobby get s job, He notifies Ally and Jack.

_****So this is Observer Pattern in Simple Terms****_

## Observer Pattern
**The Observer Pattern** defines a one-to-many
dependency between objects so that when one
object changes state, all of its dependents are
notified and updated automatically

---
**_NOTE:_**
This is not Publish-Subscribe Pattern, Publish-Subscribe pattern is a more complex pattern that allows subscribers to express interest in different types of messages and further separates publishers from subscribers. It is often used in middleware systems.
---

## Usages

The Observer Pattern is one of the most common patterns in use, and you’ll find plenty
of examples of the pattern being used in many libraries and frameworks. If we look at the
**Java Development Kit (JDK)**, for instance, both the **JavaBeans** and **Swing libraries** make use
of the Observer Pattern. The pattern’s not limited to Java either; it’s used in **JavaScript’s
events** and in **Cocoa** and **Swift’s Key-Value Observing protocol**, to name a couple of other
examples. One of the advantages of knowing design patterns is recognizing and quickly
understanding the design motivation in your favorite libraries.