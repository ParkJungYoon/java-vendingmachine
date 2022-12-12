package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateCoinsImpl implements GenerateCoins{

    @Override
    public int generate(int amount, int remainingAmount) {
        int coin;
        while (true) {
            coin = Randoms.pickNumberInList(Coin.getAllAmount());
            if (coin != amount && coin <= remainingAmount) return coin;
        }
    }
}
