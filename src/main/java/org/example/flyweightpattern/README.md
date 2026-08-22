# Flyweight Pattern

## What is the Flyweight Pattern?

The **Flyweight Pattern** is a structural design pattern used to **reduce memory usage** by sharing objects that contain the same data.

Instead of creating many identical objects, we create **one shared object** and reuse it.

---

# Real-World Scenario: Video Game Characters

Imagine a game with thousands of trees.

Each tree has common properties:

* Tree type
* Texture
* Color

Instead of storing the same information in every tree object, we can share the common data.

```text
             Tree Type
                ↓
        ┌───────┴───────┐
        ↓       ↓       ↓
      Tree    Tree    Tree
       1       2       3
```

The trees can share the same `TreeType` object while having different positions.

---

# 1. Flyweight Object

The `TreeType` contains the **shared data**.

```java
public class TreeType {

    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println(
            "Drawing " + name +
            " at (" + x + ", " + y + ")" +
            " with " + color + " color and " + texture + " texture."
        );
    }
}
```

---

# 2. Tree

The `Tree` contains data that is **unique to each tree**, such as its position.

```java
public class Tree {

    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
```

---

# 3. Flyweight Factory

The factory manages and reuses existing `TreeType` objects.

```java
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {

    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(
            String name,
            String color,
            String texture) {

        String key = name + color + texture;

        if (!treeTypes.containsKey(key)) {
            treeTypes.put(
                key,
                new TreeType(name, color, texture)
            );
        }

        return treeTypes.get(key);
    }
}
```

If the same tree type is requested again, the factory returns the **existing object** instead of creating a new one.

---

# 4. Using the Flyweight Pattern

```java
public class Main {

    public static void main(String[] args) {

        TreeType oak = TreeTypeFactory.getTreeType(
            "Oak",
            "Green",
            "OakTexture"
        );

        Tree tree1 = new Tree(10, 20, oak);
        Tree tree2 = new Tree(50, 80, oak);
        Tree tree3 = new Tree(100, 150, oak);

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}
```

All three trees share the same `TreeType` object.

```text
              TreeType
          "Oak, Green, Texture"
                 ↑
        ┌────────┼────────┐
        │        │        │
      Tree 1   Tree 2   Tree 3
      (10,20)  (50,80) (100,150)
```

---

# Intrinsic vs Extrinsic State

The Flyweight Pattern separates data into two types.

### Intrinsic State

Data that is **shared** between objects.

```text
Tree Type
Color
Texture
```

This belongs to `TreeType`.

### Extrinsic State

Data that is **unique** to each object.

```text
X position
Y position
```

This belongs to `Tree`.

---

# Key Idea

> **Reuse objects that contain common data instead of creating duplicate objects.**

```text
Without Flyweight:

Tree 1 → Oak + Texture + Color
Tree 2 → Oak + Texture + Color
Tree 3 → Oak + Texture + Color


With Flyweight:

              TreeType
           Oak + Texture + Color
             ↙    ↓    ↘
          Tree1 Tree2 Tree3
           Position data
```

The Flyweight Pattern is especially useful when an application needs to create **large numbers of similar objects**, helping reduce memory consumption.
