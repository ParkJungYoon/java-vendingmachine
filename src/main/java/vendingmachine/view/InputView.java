package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readTotalAmount() {
        OutputView.printInputTotalAmountMessage();
        return Console.readLine();
    }
}