package vendingmachine.domain;

@FunctionalInterface
public interface GenerateCoins {

    int generate(int amount, int remainingAmount);
}