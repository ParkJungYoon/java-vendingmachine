package vendingmachine.repository;

import java.util.*;

public class VendingMachineRepository {
    private static int AmountOfInput = 0;
    private static final Map<String, List<Integer>> vendingMachine = new HashMap<>();

    public static void productRegistration(List<String> namePriceQuantity) {
        String name = namePriceQuantity.get(0);
        List<Integer> priceQuantity = Arrays.asList(Integer.parseInt(namePriceQuantity.get(1)), Integer.parseInt(namePriceQuantity.get(2)));
        vendingMachine.put(name, priceQuantity);
    }

    public static void setAmountOfInput(int coin) {
        AmountOfInput = coin;
    }

    public static void purchase(String name) {
        vendingMachine.put(name, Arrays.asList(vendingMachine.get(name).get(0), vendingMachine.get(name).get(1) - 1));
        AmountOfInput -= vendingMachine.get(name).get(0);
    }

    public static boolean isPossibleToBuyByName(String name) {
        return AmountOfInput >= vendingMachine.get(name).get(0);
    }

    public static boolean isPossibleToBuy() {
        List<Integer> price = new ArrayList<>();
        Collection<List<Integer>> values = vendingMachine.values();
        for (List<Integer> value : values) {
            price.add(value.get(0));
        }
        return AmountOfInput >= Collections.min(price);
    }

    public static boolean haveStock(String name) {
        return vendingMachine.get(name).get(1) >= 1;
    }

    public static boolean isExistProduct(String name) {
        return vendingMachine.keySet().contains(name);
    }

    public static int getAmountOfInput() {
        return AmountOfInput;
    }
}
