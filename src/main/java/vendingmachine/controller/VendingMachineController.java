package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.GenerateCoins;
import vendingmachine.domain.GenerateCoinsImpl;
import vendingmachine.repository.CoinRepository;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class VendingMachineController {
    public void run() {
        coinSetUp(initAmount());
        OutputView.printTotalCoins();
    }

    private void coinSetUp(int amount) {
        GenerateCoins generateCoins = new GenerateCoinsImpl();
        int remainingAmount = amount;
        while (true) {
            if (remainingAmount == 0) return;
            int coin = generateCoins.generate(amount, remainingAmount);
            CoinRepository.addCoin(Coin.getTypeByAmount(coin));
            remainingAmount -= coin;
        }
    }

    private int initAmount() {
        int amount = repeat(InputView::readTotalAmount);
        return amount;
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }
}
