package org.example.chainofresponsibilities;

public class Level2Support extends SupportHandler {

    public Level2Support(SupportHandler next) {
        super(next);
    }

    public void support(String problem){
        System.out.println("Starting level 2 support");
        if(problem.startsWith("Level2")){
            System.out.println("Supporting by level 2");
        }else{
            System.out.println("Cannot be supported by level 2");
            nextHandler.support(problem);
        }
    }
}
