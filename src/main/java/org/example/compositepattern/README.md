# Composite Pattern

## What is the Composite Pattern in Simple Terms?

Imagine a file system structure. You have two main things:
1. **Files** (e.g., `document.txt`, `image.png`)
2. **Folders** (which can contain files and other folders)

If you want to find the total size or list all details of a directory tree, it's convenient to treat files and folders the exact same way. You don't want to check: *"Is this a file? Or is it a folder containing files?"* at every level of your traversal logic.

The Composite Pattern lets you compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects (Files) and compositions of objects (Folders) uniformly.

## Real-World Analogy
- Organizational Structure: An employee could be a developer (leaf) or a manager (composite) who manages other developers and managers. They all share common operations like `getSalary()` or `work()`.

## Breaking It Down Like an Engineer
- **Component Interface** (`FileSystemComponent`): Declares the interface for all elements in the composition.
- **Leaf** (`File`): Represents leaf behavior (no children).
- **Composite** (`Directory`): Defines behavior for components having children and stores child components.
