package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.validator.CoinValidator.*;

public class InputView {

    public static int readTotalAmount() {
        OutputView.printInputTotalAmountMessage();
        String amount = Console.readLine();

        validateNonNumeric(amount);
        validateUnit(Integer.parseInt(amount));
        validateAmountRange(Integer.parseInt(amount));
        return Integer.parseInt(amount);
    }
}
