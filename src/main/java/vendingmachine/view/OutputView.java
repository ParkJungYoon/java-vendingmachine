package vendingmachine.view;

public class OutputView {
    private final static String TOTAL_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String TOTAL_AMOUNT_COINS = "자판기가 보유한 동전";

    public static void printInputTotalAmountMessage() {
        System.out.println(TOTAL_AMOUNT_MESSAGE);
    }

    public static void printTotalCoins() {
        System.out.println(TOTAL_AMOUNT_COINS);
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}
