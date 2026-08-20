package org.example.chainofresponsibilities;

public class ManagerSupport extends SupportHandler{

    public ManagerSupport(SupportHandler next) {
        super(next);
    }

    @Override
    public void support(String problem) {
        System.out.println("Starts supporting by manager");
        if(problem.startsWith("manager")){
            System.out.println("Supporting by manager..");
        }else{
            System.out.println("Cannot be suppported by manager..");
        }
    }
}
