# Prototype Pattern

## What is the Prototype Pattern in Simple Terms?

Imagine you are developing a video game, and you need to spawn hundreds of monster objects. Some of these monsters have complex initializations (e.g., loading texture files, setting up coordinate metrics, loading AI paths). 

Instead of creating every monster from scratch with expensive resource operations, you create a few configured "prototype" monsters once. When you need a new monster, you simply **clone** (copy) one of the prototype monsters and adjust small properties like coordinates or health.

This avoids the overhead of creating new instances from scratch and makes creating copies of objects simple and fast.

## Real-World Analogy
- Cell Division: In biology, cells divide to clone themselves. The new cell is created by copying the DNA structure of the existing cell.
- Photocopying: Instead of typing a page again from scratch, you put the original on a copier to duplicate it.

## Breaking It Down Like an Engineer
- **Prototype Interface** (`Prototype`): Declares the interface for cloning itself.
- **Concrete Prototype** (`Monster`): Implements the cloning operation (usually by copying the object's properties to a new instance).
- **Client**: Creates a new object by asking a prototype to clone itself.
