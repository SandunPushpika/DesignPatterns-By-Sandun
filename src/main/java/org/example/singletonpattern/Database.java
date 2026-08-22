package org.example.singletonpattern;

public class Database {
    private String dbName = "NoDb";
    private static Database db;

    private Database(){}

    public static synchronized Database getInstance(){
        if(db == null){
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
