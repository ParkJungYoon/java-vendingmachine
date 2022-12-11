package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.HashMap;
import java.util.Map;

public class CoinRepository {
    private static final Map<Coin, Integer> coins= new HashMap<>();

    static {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public static void addCoin(Coin coin) {
        coins.put(coin, coins.get(coin) + 1);
    }

    public static Map<Coin, Integer> getCoins() {
        return coins;
    }

//    public static Map<Coin, Integer> getHaveCoins() {
//
//    }
}
