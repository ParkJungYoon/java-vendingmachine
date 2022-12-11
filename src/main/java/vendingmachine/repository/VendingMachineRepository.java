package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineRepository {
    private static final Map<String, List<Integer>> vendingMachine = new HashMap<>();

    public static void productRegistration(List<String> namePriceQuantity) {
        String name = namePriceQuantity.get(0);
        List<Integer> priceQuantity = Arrays.asList(Integer.parseInt(namePriceQuantity.get(1)), Integer.parseInt(namePriceQuantity.get(2)));
        vendingMachine.put(name, priceQuantity);
    }

    public static Map<String, List<Integer>> getVendingMachine() {
        return vendingMachine;
    }

}
