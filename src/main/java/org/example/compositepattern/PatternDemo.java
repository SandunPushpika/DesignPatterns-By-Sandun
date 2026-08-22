package org.example.compositepattern;

public class PatternDemo {
    public static void main(String[] args) {
        File file1 = new File("Document.txt", 120);
        File file2 = new File("Image.png", 340);
        File file3 = new File("Setup.exe", 1024);

        Directory subDirectory = new Directory("SubFolder");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory rootDirectory = new Directory("RootFolder");
        rootDirectory.addComponent(subDirectory);
        rootDirectory.addComponent(file3);

        rootDirectory.showDetails();
    }
}
