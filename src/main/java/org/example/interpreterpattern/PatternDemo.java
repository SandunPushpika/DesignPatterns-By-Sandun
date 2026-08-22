package org.example.interpreterpattern;

public class PatternDemo {
    public static void main(String[] args) {
        Expression isJava = new TerminalExpression("Java");
        Expression isSpring = new TerminalExpression("Spring");
        Expression isJavaDeveloper = new AndExpression(isJava, isSpring);

        Expression isCPlusPlus = new TerminalExpression("C++");
        Expression isBackendDeveloper = new OrExpression(isJavaDeveloper, isCPlusPlus);

        System.out.println("Does context have Java Developer skills? " + isJavaDeveloper.interpret("Java Spring Hibernate"));
        System.out.println("Does context have Backend Developer skills? " + isBackendDeveloper.interpret("C++ Python"));
        System.out.println("Does context have Backend Developer skills? " + isBackendDeveloper.interpret("Java Developer"));
    }
}
