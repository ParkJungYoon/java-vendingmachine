package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static List<Integer> getAllAmount() {
        ArrayList<Integer> allAmount = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            allAmount.add(coin.getAmount());
        }
        return allAmount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin getTypeByAmount(int amount) {
        Coin type = null;
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == amount) type = coin;
        }
        return type;
    }
}
