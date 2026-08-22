# Factory Pattern

## What is the Factory Pattern?

The **Factory Pattern** is a creational design pattern used to create objects without exposing the object creation logic to the client.

Instead of the client directly creating a concrete object using `new`, it asks a **Factory** or a dedicated class to create the appropriate object.

---

# Real-World Scenario: Pizza Store

Imagine a pizza store that sells different types of pizza.

The customer might order:

* Veggie Pizza
* Chicken Pizza
* Cheese Pizza
* Pepperoni Pizza

The customer shouldn't need to know how each pizza is created.

They simply say:

> "I want a Veggie Pizza."

The pizza store decides which concrete pizza object needs to be created.

```text id="k8j2qf"
Customer
    ↓
Pizza Store
    ↓
Which pizza?
   / \
  /   \
Veggie Chicken
Pizza   Pizza
```

---

# 1. Pizza — Abstract Product

The `Pizza` class defines the common behavior of all pizzas.

```java id="x3n4qk"
public abstract class Pizza {

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking pizza...");
    }

    public void cut() {
        System.out.println("Cutting pizza...");
    }

    public void box() {
        System.out.println("Boxing pizza...");
    }
}
```

Every type of pizza can have its own implementation of `prepare()`.

---

# 2. Concrete Products

## Veggie Pizza

```java id="q7p5we"
public class VeggiePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza...");
    }
}
```

## Chicken Pizza

```java id="m2v8az"
public class ChickenPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza...");
    }
}
```

These are the **concrete products** that the factory will create.

---

# 3. PizzaStore — Creator

The `PizzaStore` is an abstract class responsible for defining the pizza-ordering process.

```java id="n4j6tz"
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
```

Notice that `PizzaStore` does not directly create:

```java id="2h3w4f"
new VeggiePizza()
```

or:

```java id="7j2v5m"
new ChickenPizza()
```

Instead, it delegates the creation to:

```java id="l7d1sx"
createPizza()
```

---

# 4. NewYorkPizzaStore

The `NewYorkPizzaStore` provides the actual implementation of `createPizza()`.

```java id="v6r2mp"
public class NewYorkPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {

        if (type.equals("veggie")) {
            return new VeggiePizza();
        }

        if (type.equals("chicken")) {
            return new ChickenPizza();
        }

        return null;
    }
}
```

The `NewYorkPizzaStore` knows which concrete pizza needs to be created.

---

# 5. Using the Factory

The client doesn't need to directly create a `VeggiePizza`.

```java id="c5t8qn"
public class Main {

    public static void main(String[] args) {

        PizzaStore store = new NewYorkPizzaStore();

        Pizza pizza = store.orderPizza("veggie");
    }
}
```

Output:

```text id="4y7wqa"
Preparing Veggie Pizza...
Baking pizza...
Cutting pizza...
Boxing pizza...
```

The client only knows about:

```java id="y4r1ds"
PizzaStore
```

and:

```java id="h8p3kd"
Pizza
```

It doesn't need to know the concrete implementation.

---

# How It Works

The flow is:

```text id="6x4mnp"
             Client
                ↓
        NewYorkPizzaStore
                ↓
          createPizza()
                ↓
        ┌───────┴────────┐
        ↓                ↓
  VeggiePizza      ChickenPizza
```

The important thing is that the **creation of the concrete pizza is separated from the code that uses the pizza**.

---

# Why Use the Factory Pattern?

Without the Factory Pattern, the client might do this:

```java id="3m8xpv"
Pizza pizza;

if (type.equals("veggie")) {
    pizza = new VeggiePizza();
} else if (type.equals("chicken")) {
    pizza = new ChickenPizza();
}
```

Now the client needs to know about every concrete pizza class.

With the Factory Pattern:

```java id="5x7kqz"
Pizza pizza = store.orderPizza("veggie");
```

The client doesn't need to know how the pizza is created.

---

# Key Idea

> **The Factory Pattern moves object creation to a dedicated place instead of making the client responsible for creating concrete objects.**

In this example:

| Component           | Responsibility                |
| ------------------- | ----------------------------- |
| `Pizza`             | Abstract product              |
| `VeggiePizza`       | Concrete product              |
| `ChickenPizza`      | Concrete product              |
| `PizzaStore`        | Defines the creation process  |
| `NewYorkPizzaStore` | Creates the appropriate pizza |
| `Main`              | Client                        |

---

# Simple Analogy

Think about going to a pizza store.

You don't walk into the kitchen and say:

> "Give me the dough, cheese, vegetables, sauce, and oven."

You simply say:

> **"I'd like a Veggie Pizza."**

The pizza store handles the details of creating it.

```text id="x2m8vr"
Customer
   ↓
"I want Veggie Pizza"
   ↓
Pizza Store
   ↓
Create VeggiePizza
   ↓
Prepare → Bake → Cut → Box
   ↓
Pizza
```

That's the core idea behind the **Factory Pattern**.
