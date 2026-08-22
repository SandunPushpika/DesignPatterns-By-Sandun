package org.example.flyweightpattern;

/**
 * What is happening in the Flyweight Pattern is that
 * it separates the shared state from the unique state.
 *
 * Tree - contains the unique (extrinsic) state of each object,
 *        such as its location (x, y).
 *
 * TreeType - contains the shared (intrinsic) state of a tree,
 *            such as its name, color, and texture.
 *
 * Instead of creating and storing the shared features repeatedly
 * for every Tree object, we create a single TreeType object and
 * share it among multiple Tree objects.
 *
 * This helps reduce memory usage when a large number of similar
 * objects need to be created.
 */
public class FlyWeightPattern {
    public static void main(String[] args) {
        TreeType type = TreeTypeFactory.getTreeType("test", "red", "rough");

        Tree t1 = new Tree(10,10, type);
        Tree t2 = new Tree(20,20, type);
        Tree t3 = new Tree(30,30, type);

        t1.draw();
        t2.draw();
        t3.draw();
    }
}