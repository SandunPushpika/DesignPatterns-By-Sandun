package org.example.chainofresponsibilities;

public class Level1Support extends SupportHandler{

    public Level1Support(SupportHandler next) {
        super(next);
    }

    @Override
    public void support(String problem) {
        System.out.println("Level1 support starts....");
        if(problem.startsWith("Level1")){
            System.out.println("Supporting Level1");
        }else{
            System.out.println("Cannot be supported by Level1");
            nextHandler.support(problem);
        }
    }
}
