package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.repository.CoinRepository;

import java.util.Map;

public class OutputView {
    private final static String TOTAL_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String TOTAL_AMOUNT_COINS = "자판기가 보유한 동전";
    private final static String COINS_VIEW_FORMAT = "%d원 - %d개";
    private final static String PRODUCT_REGISTRATION = "상품명과 가격, 수량을 입력해 주세요.";

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

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}
