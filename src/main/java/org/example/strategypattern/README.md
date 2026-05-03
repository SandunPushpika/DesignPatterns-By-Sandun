# The Strategy Pattern
 
## What is Strategy Pattern in Simple Terms?

Think there is a person Bobby, he needs to travel to work every day.
There are multiple ways he can go:
- By Car
- By Bus
- By Bike

Now here’s the situation:

**Bobby:** Today traffic is crazy, I should take the bike.
Next day…
**Bobby:** It’s raining, better take the car.
Another day…
**Bobby:** I want to save money today, I’ll take the bus.

So Bobby is not stuck with one way of traveling.
He can change his **behavior** (travel method) depending on the situation.

Instead of hardcoding:

``` “Bobby always drives a car” ```

He chooses the best **strategy** at runtime.

**_So this is Strategy Pattern in Simple Terms_**

## The Strategy Pattern
**The Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.
It lets the algorithm vary independently from the clients that use it.

## Breaking It Down Like an Engineer

* **Bobby** → Context (the main class using a strategy)
* **Car / Bus / Bike** → Different strategies (algorithms)
* **Travel behavior** → The interchangeable logic

Instead of Writing,

```java
if(condition == "rain") {
    DriveCar();
}
else if(condition == "traffic") {
    RideBike();
}
```

We write,

```java
ITravelStrategy strategy = new BikeStrategy();
bobby.SetStrategy(strategy);
bobby.Travel();
```

**_Have a look at the example code to understand this._**