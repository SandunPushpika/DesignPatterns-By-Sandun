# Builder Pattern

## What is the Builder Pattern?

The **Builder Pattern** is a creational design pattern used to construct complex objects **step by step**.

Instead of creating an object using a large constructor with many parameters, the Builder Pattern separates the **construction process** from the **final object**.

This is especially useful when:

* An object has many properties.
* Different versions of the object require different configurations.
* Object creation involves multiple steps.
* We want the construction logic to be easier to understand and maintain.

---

# Real-World Scenario: Building a Car

Imagine a car manufacturer that produces different types of cars.

For example:

* BMW
* Audi
* Mercedes

Although these cars are different, the process of building them is similar.

A car may contain:

* Engine
* Wheels
* Body
* Interior
* Transmission
* GPS
* Air conditioning

The manufacturer doesn't want the client to manually create every component and figure out the construction process.

Instead, the client can say:

> "Build me a BMW."

or

> "Build me an Audi."

The appropriate builder takes care of the construction process.

---

# Problem Without the Builder Pattern

Without the Builder Pattern, we might create a `Car` using a large constructor:

```csharp
Car car = new Car(
    "BMW",
    "V8",
    4,
    "Automatic",
    "Leather",
    true,
    true
);
```

This becomes difficult to understand.

What does `true, true` mean?

What happens when we add more properties?

```csharp
Car car = new Car(
    "BMW",
    "V8",
    4,
    "Automatic",
    "Leather",
    true,
    true,
    true,
    false,
    "Black"
);
```

The constructor becomes difficult to maintain and easy to misuse.

---

# Solution: Builder Pattern

With the Builder Pattern, we separate the **Car object** from the **process of building the Car**.

The basic structure looks like this:

```text
             Car
              ▲
              |
       Abstract CarBuilder
          /          \
         /            \
 BMWBuilder        AudiBuilder
```

The `CarBuilder` defines **how a car should be constructed**, while the concrete builders decide **how a specific car is constructed**.

---

# 1. Product — Car

The `Car` is the object that we ultimately want to create.

```csharp
public class Car
{
    public string Brand { get; set; }
    public string Engine { get; set; }
    public int Wheels { get; set; }
    public string Transmission { get; set; }
    public string Interior { get; set; }

    public void ShowDetails()
    {
        Console.WriteLine($"Brand: {Brand}");
        Console.WriteLine($"Engine: {Engine}");
        Console.WriteLine($"Wheels: {Wheels}");
        Console.WriteLine($"Transmission: {Transmission}");
        Console.WriteLine($"Interior: {Interior}");
    }
}
```

This class represents the **final product**.

The `Car` itself does not know how it was built.

---

# 2. Abstract Car Builder

Next, we create an abstract `CarBuilder`.

```csharp
public abstract class CarBuilder
{
    protected Car car;

    public CarBuilder()
    {
        car = new Car();
    }

    public abstract void BuildBrand();
    public abstract void BuildEngine();
    public abstract void BuildWheels();
    public abstract void BuildTransmission();
    public abstract void BuildInterior();

    public Car GetCar()
    {
        return car;
    }
}
```

The abstract builder defines the **steps required to build a car**.

Notice that it doesn't specify exactly how those steps should be implemented.

For example:

```csharp
BuildEngine();
BuildWheels();
BuildTransmission();
```

These methods are common construction steps, but BMW and Audi can implement them differently.

---

# 3. BMW Builder

Now we create a concrete builder for BMW.

```csharp
public class BmwBuilder : CarBuilder
{
    public override void BuildBrand()
    {
        car.Brand = "BMW";
    }

    public override void BuildEngine()
    {
        car.Engine = "BMW TwinPower Turbo";
    }

    public override void BuildWheels()
    {
        car.Wheels = 4;
    }

    public override void BuildTransmission()
    {
        car.Transmission = "Automatic";
    }

    public override void BuildInterior()
    {
        car.Interior = "Premium Leather";
    }
}
```

The `BmwBuilder` knows the specific details required to construct a BMW.

---

# 4. Audi Builder

Similarly, we can create an Audi builder.

```csharp
public class AudiBuilder : CarBuilder
{
    public override void BuildBrand()
    {
        car.Brand = "Audi";
    }

    public override void BuildEngine()
    {
        car.Engine = "Audi TFSI";
    }

    public override void BuildWheels()
    {
        car.Wheels = 4;
    }

    public override void BuildTransmission()
    {
        car.Transmission = "S-Tronic";
    }

    public override void BuildInterior()
    {
        car.Interior = "Audi Premium Interior";
    }
}
```

Now we have two different ways of constructing a car.

---

# 5. Director

The **Director** controls the order in which the construction steps are performed.

```csharp
public class CarDirector
{
    public Car BuildCar(CarBuilder builder)
    {
        builder.BuildBrand();
        builder.BuildEngine();
        builder.BuildWheels();
        builder.BuildTransmission();
        builder.BuildInterior();

        return builder.GetCar();
    }
}
```

The Director doesn't care whether the builder is:

* BMW
* Audi
* Mercedes
* Tesla

It only knows that the builder can perform the required construction steps.

---

# 6. Using the Builder Pattern

Now the client can create different cars easily.

```csharp
CarDirector director = new CarDirector();

CarBuilder bmwBuilder = new BmwBuilder();

Car bmw = director.BuildCar(bmwBuilder);

bmw.ShowDetails();
```

Output:

```text
Brand: BMW
Engine: BMW TwinPower Turbo
Wheels: 4
Transmission: Automatic
Interior: Premium Leather
```

We can create an Audi using exactly the same construction process.

```csharp
CarBuilder audiBuilder = new AudiBuilder();

Car audi = director.BuildCar(audiBuilder);

audi.ShowDetails();
```

Output:

```text
Brand: Audi
Engine: Audi TFSI
Wheels: 4
Transmission: S-Tronic
Interior: Audi Premium Interior
```

---

# Complete Structure

The complete architecture can be visualized as:

```text
                     Client
                       |
                       v
                  CarDirector
                       |
                       v
                CarBuilder (abstract)
                 /             \
                /               \
               v                 v
        BmwBuilder          AudiBuilder
               \                 /
                \               /
                 v             v
                       Car
                    (Product)
```

---

# How It Works

The process can be understood in four steps.

### Step 1 — Client chooses a builder

```csharp
CarBuilder builder = new BmwBuilder();
```

The client decides which type of car it wants.

---

### Step 2 — Director starts the construction

```csharp
CarDirector director = new CarDirector();

Car car = director.BuildCar(builder);
```

The Director controls the construction process.

---

### Step 3 — Builder performs each step

The BMW builder performs:

```text
BuildBrand()
      ↓
BuildEngine()
      ↓
BuildWheels()
      ↓
BuildTransmission()
      ↓
BuildInterior()
```

Each step modifies the `Car` object.

---

### Step 4 — Final Car is returned

Finally:

```csharp
return builder.GetCar();
```

The client receives the fully constructed `Car`.

---

# Why Is This Useful?

Imagine that tomorrow the company wants to add Mercedes.

Without the Builder Pattern, we might have to modify a large amount of object creation code.

With the Builder Pattern, we can simply create:

```csharp
public class MercedesBuilder : CarBuilder
{
    public override void BuildBrand()
    {
        car.Brand = "Mercedes";
    }

    public override void BuildEngine()
    {
        car.Engine = "Mercedes AMG Engine";
    }

    public override void BuildWheels()
    {
        car.Wheels = 4;
    }

    public override void BuildTransmission()
    {
        car.Transmission = "9G-Tronic";
    }

    public override void BuildInterior()
    {
        car.Interior = "Luxury Leather";
    }
}
```

The existing `CarDirector` doesn't need to change.

```csharp
CarBuilder builder = new MercedesBuilder();

Car mercedes = director.BuildCar(builder);
```

This demonstrates an important design principle:

> **Open for extension, closed for modification.**

We can add new builders without changing the existing construction process.

---

# Advantages

## 1. Separates Construction from Representation

The `Car` represents the final object.

The builders are responsible for constructing it.

This gives each class a clear responsibility.

---

## 2. Supports Different Representations

The same construction process can create different types of cars.

```text
Build Car
   |
   +---- BMW
   |
   +---- Audi
   |
   +---- Mercedes
   |
   +---- Tesla
```

---

## 3. Easier to Maintain

Instead of having complicated constructors, each construction step has its own method.

```csharp
BuildEngine();
BuildWheels();
BuildTransmission();
```

This makes the code easier to understand.

---

## 4. Easy to Extend

Adding another type of car doesn't require changing the existing builders.

We simply create another builder.

```csharp
public class TeslaBuilder : CarBuilder
{
    // Tesla-specific implementation
}
```

---

## 5. Controls the Construction Process

The Director can ensure that the construction steps happen in the correct order.

For example:

```text
Engine
  ↓
Wheels
  ↓
Transmission
  ↓
Interior
```

The client doesn't need to know the exact construction sequence.

---

# Builder Pattern vs Factory Pattern

Builder and Factory are both creational design patterns, but they solve different problems.

### Factory

Factory focuses on:

> **Which object should I create?**

For example:

```csharp
Car car = CarFactory.Create("BMW");
```

The Factory decides which object to create.

---

### Builder

Builder focuses on:

> **How should I construct this object?**

For example:

```csharp
builder.BuildEngine();
builder.BuildWheels();
builder.BuildInterior();
```

The Builder controls the construction process.

---

# Simple Analogy

Think about ordering a customized car.

You tell the manufacturer:

> "I want a BMW."

The manufacturer knows how to build a BMW.

You may then specify:

> Engine → V8
> Interior → Leather
> Transmission → Automatic
> Wheels → 18 inch

The manufacturer follows a series of construction steps and eventually gives you the completed car.

That is the core idea behind the **Builder Pattern**.

---

# Key Components

| Component     | Responsibility                               |
| ------------- | -------------------------------------------- |
| `Car`         | Final product                                |
| `CarBuilder`  | Defines construction steps                   |
| `BmwBuilder`  | Builds a BMW                                 |
| `AudiBuilder` | Builds an Audi                               |
| `CarDirector` | Controls construction order                  |
| Client        | Chooses the builder and requests the product |

---

# Key Idea to Remember

The most important thing to remember about the Builder Pattern is:

> **Builder Pattern separates the complex construction of an object from the object itself.**

In our example:

```text
Car
 ↑
 |
CarBuilder
 ↑       ↑
 |       |
BMW     Audi
```

`Car` is **what we build**.

`CarBuilder` defines **how a car is built**.

`BmwBuilder` and `AudiBuilder` define **how their specific cars are built**.

`CarDirector` controls **the order of construction**.

This makes the system easier to extend, maintain, and understand.
