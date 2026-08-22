# Singleton Pattern

## What is the Singleton Pattern?

The **Singleton Pattern** is a creational design pattern that ensures a class has **only one instance** throughout the application.

It also provides a **global access point** to that instance.

---

# Real-World Scenario: Database Connection

Imagine an application that needs to work with a database.

We don't want every part of the application to create a completely new `Database` object.

Instead, we want one shared database instance:

```text
Application
     |
     v
 Database
    /|\
   / | \
  v  v  v
Class Class Class
```

Every part of the application uses the **same `Database` instance**.

This can be useful for managing resources that should be shared, such as:

* Database connections
* Configuration managers
* Logging services
* Application-wide settings

---

# 1. Database Class

The `Database` class is implemented as a Singleton.

```java
package org.example.singletonpattern;

public class Database {

    private String dbName = "NoDb";

    private static Database db;

    private Database() {}

    public static synchronized Database getInstance() {

        if (db == null) {
            db = new Database();
        }

        return db;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void printDatabase() {
        System.out.println(dbName);
    }
}
```

---

# How Does It Work?

There are three important parts of this implementation.

## 1. Private Constructor

```java
private Database() {}
```

The constructor is private so that other classes cannot directly create a `Database` object.

This is not allowed:

```java
Database db = new Database();
```

Instead, the application must use:

```java
Database.getInstance();
```

---

## 2. Static Instance

```java
private static Database db;
```

This variable stores the **single instance** of the `Database`.

Initially:

```text
db = null
```

---

## 3. getInstance()

```java
public static synchronized Database getInstance() {

    if (db == null) {
        db = new Database();
    }

    return db;
}
```

The first time `getInstance()` is called, the object is created.

```text
First call
    ↓
db == null
    ↓
Create Database
    ↓
Store it in db
```

Every subsequent call returns the same object.

```text
Second call
    ↓
db != null
    ↓
Return existing object
```

---

# Using the Singleton

```java
public class Main {

    public static void main(String[] args) {

        Database db1 = Database.getInstance();

        Database db2 = Database.getInstance();

        System.out.println(db1 == db2);
    }
}
```

Output:

```text
true
```

This proves that both variables refer to the **same object**.

```text
        Database
       ┌─────────┐
       │ Instance│
       └─────────┘
          ↑   ↑
          │   │
        db1  db2
```

---

# Sharing Data

Because `db1` and `db2` refer to the same object, changes made through one reference are visible through the other.

```java
Database db1 = Database.getInstance();

db1.setDbName("MySQL");

Database db2 = Database.getInstance();

db2.printDatabase();
```

Output:

```text
MySQL
```

Why?

Because:

```text
db1 ─────┐
         ↓
      Database
         ↑
db2 ─────┘
```

There is only **one `Database` object**.

---

# Why `synchronized`?

The method is declared as:

```java
public static synchronized Database getInstance()
```

This is important when multiple threads may try to create the Singleton at the same time.

Without synchronization, two threads could potentially do this:

```text
Thread 1              Thread 2
   ↓                     ↓
db == null            db == null
   ↓                     ↓
Create object         Create object
   ↓                     ↓
   Object 1             Object 2
```

That would violate the Singleton principle.

With `synchronized`, only one thread can execute `getInstance()` at a time.

```text
Thread 1
   ↓
getInstance()
   ↓
Create Database
   ↓
Return instance

Thread 2
   ↓
getInstance()
   ↓
Return existing instance
```

---

# Key Idea

> **The Singleton Pattern ensures that a class has only one instance and provides a global access point to that instance.**

In our example:

```text
Database
   │
   ├── Private constructor
   │
   ├── Static instance
   │
   └── getInstance()
             ↓
       Single Database
          Instance
```

The important points to remember are:

* **Private constructor** → Prevents external object creation.
* **Static instance** → Stores the single object.
* **`getInstance()`** → Provides access to the object.
* **`synchronized`** → Helps make instance creation thread-safe.

---

# Simple Analogy

Think of a company with **one central database**.

You don't create a completely new database every time an employee needs information.

Instead, everyone accesses the **same central database**.

```text
Employee 1 ──┐
Employee 2 ──┤
Employee 3 ──┼──→ One Database
Employee 4 ──┤
Employee 5 ──┘
```

That is the basic idea behind the **Singleton Pattern**.
