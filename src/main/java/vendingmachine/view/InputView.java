package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.util.InputValidator.*;

public class InputView {
    public static int readTotalAmount() {
        OutputView.printInputTotalAmountMessage();
        String amount = Console.readLine();

        validateNonNumeric(amount);
        validateUnit(Integer.parseInt(amount));
        validateAmountRange(Integer.parseInt(amount));
        return Integer.parseInt(amount);
    }

    public static String readNamePriceQuantity() {
        OutputView.printProductRegistrationMessage();
        return Console.readLine();
    }

    public static int readAmountOfInput() {
        OutputView.printAmountInputMessage();
        String amount = Console.readLine();

        validateNonNumeric(amount);
        validateUnit(Integer.parseInt(amount));
        validateAmountRange(Integer.parseInt(amount));
        return Integer.parseInt(amount);
    }

    public static String readPurchaseProductName() {
        OutputView.printInputPurchaseProductName();
        String name = Console.readLine();

        validateExistProduct(name);
        return name;
    }
}
