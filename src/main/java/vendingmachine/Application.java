package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        validateProduct("[콜라,1500,20];[사이다,1000,10]");
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.run();
    }
}
