# Chain of Responsibility Pattern

## What is the Chain of Responsibility Pattern?

The **Chain of Responsibility** is a behavioral design pattern where a request is passed through a **chain of handlers** until one of them can handle it.

Instead of one class handling every request, each handler checks whether it can handle the request. If not, it passes it to the next handler.

---

# Real-World Scenario: Customer Support

Imagine a company's customer support system:

```text
Customer Request
       ↓
Level 1 Support
       ↓
Level 2 Support
       ↓
Manager
```

* **Level 1** → Handles simple issues
* **Level 2** → Handles technical issues
* **Manager** → Handles serious or exceptional issues

---

# 1. Abstract Handler

```java
public abstract class SupportHandler {

    protected SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handle(String issue);
}
```

The handler contains a reference to the **next handler** in the chain.
you can also create a **constructor** to set the next handler.
---

# 2. Level 1 Support

```java
public class Level1Support extends SupportHandler {

    @Override
    public void handle(String issue) {

        if (issue.equals("password")) {
            System.out.println("Level 1 solved the issue.");
        } else if (next != null) {
            next.handle(issue);
        }
    }
}
```

---

# 3. Level 2 Support

```java
public class Level2Support extends SupportHandler {

    @Override
    public void handle(String issue) {

        if (issue.equals("server")) {
            System.out.println("Level 2 solved the issue.");
        } else if (next != null) {
            next.handle(issue);
        }
    }
}
```

---

# 4. Manager

```java
public class Manager extends SupportHandler {

    @Override
    public void handle(String issue) {
        System.out.println("Manager handled the issue.");
    }
}
```

---

# 5. Creating the Chain

```java
public class Main {

    public static void main(String[] args) {

        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler manager = new Manager();

        level1.setNext(level2);
        level2.setNext(manager);

        level1.handle("server");
    }
}
```

Output:

```text
Level 2 solved the issue.
```

The request flows through the chain:

```text
"server"
   ↓
Level 1
   ↓
Level 2 → Handles it
```

If Level 1 cannot handle the request, it passes it to Level 2. If Level 2 cannot handle it, it passes it to the Manager.

---

# Key Idea

> **Pass the request along a chain until a suitable handler handles it.**

```text
Request
   ↓
Handler 1
   ↓
Handler 2
   ↓
Handler 3
```

Each handler either:

1. **Handles the request**, or
2. **Passes it to the next handler**.

This keeps the sender of the request **loosely coupled** from the object that handles it.
