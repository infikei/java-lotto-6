package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private int amount;
    private List<Lotto> purchasedLottos;
    private Lotto winningLotto;
    private int lottoBonus;
    private LottoStatistics lottoStatistics;

    public void playGame() {
        inputAmount();
        purchaseLottos();
        inputWinningLotto();
        inputLottoBonus();
        printStatistics();
    }

    private void inputAmount() {
        while (true) {
            try {
                amount = new Amount(inputView.inputAmount()).getAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void purchaseLottos() {
        purchasedLottos = new LottosPurchase(amount).getLottos();

        outputView.printCountsOfPurchasing(purchasedLottos.size());
        outputView.printLottos(purchasedLottos);
        System.out.println();
    }

    private void inputWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = Lotto.convertToIntegers(inputView.inputWinningNumbers());
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void inputLottoBonus() {
        while (true) {
            try {
                lottoBonus = new LottoBonus(winningLotto, inputView.inputBonusNumber()).getNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void printStatistics() {
        lottoStatistics = new LottoStatistics(purchasedLottos, winningLotto, lottoBonus, amount);

        outputView.printRankCounts(lottoStatistics.getRankCounter());
        outputView.printWinningRate(lottoStatistics.getWinningRate());
    }
}
