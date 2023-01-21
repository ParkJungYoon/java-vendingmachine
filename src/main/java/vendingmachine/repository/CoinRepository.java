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

    private CoinRepository() {
    }

    public static void addCoin(Coin coin) {
        coins.put(coin, coins.get(coin) + 1);
    }

    public static int calculateChange(Coin coin) {
        int change = VendingMachineRepository.getAmountOfInput();
        int count = coins.get(coin);
        if (count * coin.getAmount() <= change) {
            change -= count * coin.getAmount();
            return count;
        }
        count = change / coin.getAmount();
        change -= count * coin.getAmount();
        return count;
    }

    public static Map<Coin, Integer> getCoins() {
        return coins;
    }
}
