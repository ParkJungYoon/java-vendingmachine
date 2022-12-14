package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.GenerateCoins;
import vendingmachine.domain.GenerateCoinsImpl;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.VendingMachineRepository;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

import static vendingmachine.util.TransformInput.transformFormat;

public class VendingMachineController {
    public void run() {
        coinSetUp(initAmount());
        OutputView.printTotalCoins();
        initNamePriceQuantity();

        purchaseProduct();
        OutputView.printChangeResult();
    }

    private void purchaseProduct() {
        VendingMachineRepository.setAmountOfInput(initAmountOfInput());

        while (true) {
            OutputView.printRemainingAmount(VendingMachineRepository.getAmountOfInput());
            if (!VendingMachineRepository.isPossibleToBuy()) break;

            purchaseOneProduct();
        }
    }

    private void purchaseOneProduct() {
        String productName = repeat(InputView::readPurchaseProductName);
        if (!VendingMachineRepository.haveStock(productName) || !VendingMachineRepository.isPossibleToBuy()) {
            return;
        }
        if (VendingMachineRepository.isPossibleToBuyByName(productName)) {
            VendingMachineRepository.purchase(productName);
        }
    }

    private int initAmountOfInput() {
        int amountOfInput = repeat(InputView::readAmountOfInput);
        return amountOfInput;
    }

    private void initNamePriceQuantity() {
        String namePriceQuantity = repeat(InputView::readNamePriceQuantity);
        for (String one : namePriceQuantity.split(";")) {
            VendingMachineRepository.productRegistration(transformFormat(one));
        }
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
