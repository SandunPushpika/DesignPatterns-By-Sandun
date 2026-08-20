package org.example.chainofresponsibilities;

public class ChainOfResponsibilities {
    public static void main(String[] args) {
        SupportHandler managerSupport = new ManagerSupport(null);
        SupportHandler level2Support = new Level2Support(managerSupport);
        SupportHandler level1Support = new Level1Support(level2Support);

        level1Support.support("Level1, I have a probelm....");
        System.out.println("End of Support Request...");
        System.out.println();

        level1Support.support("Level2, I have a probelm....");
        System.out.println("End of Support Request...");
        System.out.println();

        level1Support.support("manager, I have a probelm....");
        System.out.println("End of Support Request...");
        System.out.println();
    }
}
