package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.VendingMachineRepository;

import java.util.Map;

public class OutputView {
    private final static String TOTAL_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String TOTAL_AMOUNT_COINS = "자판기가 보유한 동전";
    private final static String COINS_VIEW_FORMAT = "%d원 - %d개";
    private final static String PRODUCT_REGISTRATION = "상품명과 가격, 수량을 입력해 주세요.";
    private final static String AMOUNT_INPUT_MESSAGE = "투입 금액을 입력해 주세요.";
    private final static String REMAINING_AMOUNT_FORMAT = "투입 금액: %d원";
    private final static String PURCHASE_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private final static String CHANGE = "잔돈";
    private final static String CHANGE_FORMAT = "%d원 - %d개";


    public static void printInputTotalAmountMessage() {
        System.out.println(TOTAL_AMOUNT_MESSAGE);
    }

    public static void printTotalCoins() {
        Map<Coin, Integer> coins = CoinRepository.getCoins();

        System.out.println(TOTAL_AMOUNT_COINS);
        for (Coin coin : Coin.values()) {
            System.out.println(String.format(COINS_VIEW_FORMAT, coin.getAmount(), coins.get(coin)));
        }
    }

    public static void printProductRegistrationMessage() {
        System.out.println(PRODUCT_REGISTRATION);
    }

    public static void printAmountInputMessage() {
        System.out.println(AMOUNT_INPUT_MESSAGE);
    }

    public static void printRemainingAmount(int remainingAmount) {
        System.out.println(String.format(REMAINING_AMOUNT_FORMAT, remainingAmount));
    }

    public static void printInputPurchaseProductName() {
        System.out.println(PURCHASE_PRODUCT_NAME);
    }

    public static void printChangeResult() {
        System.out.println(CHANGE);
        Map<Coin, Integer> coins = CoinRepository.getCoins();

        for (Coin coin : Coin.values()) {
            if (coins.get(coin) != 0) {
                int count = CoinRepository.calculateChange(coin);
                System.out.println(String.format(CHANGE_FORMAT, coin.getAmount(), count));
            }
        }
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}
