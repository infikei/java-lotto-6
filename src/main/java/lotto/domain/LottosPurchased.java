package lotto.domain;

import java.util.List;

public class LottosPurchased {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public LottosPurchased(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
    }
}
