# Decorator Pattern

## What is decorator pattern in Simple Terms?

Imagine you are having a coffee, and you may want to customize it by adding extra ingredients like milk, sugar, whipped cream, or chocolate.

You start with a plain coffee. Then, instead of creating separate classes like:

- CoffeeWithMilk
- CoffeeWithSugar
- CoffeeWithMilkAndSugar
- CoffeeWithWhippedCream
- CoffeeWithMilkSugarAndChocolate

you simply “decorate” the coffee with additional features dynamically.

## Definition

**The Decorator Pattern** attaches additional
responsibilities to an object dynamically.
Decorators provide a flexible alternative to
subclassing for extending functionality.

## Usages
A common usage of the Decorator Pattern is when you want to add optional features dynamically without changing the original class.

**Real Java Examples**

Java uses decorators heavily.
Examples:
```
BufferedReader
DataInputStream
BufferedInputStream
```

Example:

``` 
BufferedReader reader = new BufferedReader(new FileReader("test.txt")); 
```

Internally:

` BufferedReader -> FileReader `