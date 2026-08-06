package org.example.singletonpattern;

public class PatternTest {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.setDbName("db1 name");
        db.printDatabase();


        Database db1 = Database.getInstance();
        db1.printDatabase();
        db1.setDbName("db2 name");

        db.printDatabase();

    }
}
