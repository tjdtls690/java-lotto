package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.strategy.lottosissuancestrategy.AutoLottosIssuanceStrategy;
import lotto.domain.strategy.lottosissuancestrategy.LottosIssuanceStrategy;
import lotto.dto.LottoRanksDTO;
import lotto.dto.LottosDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        OutputView.printPaymentInputMessage();
        Payment payment = InputView.inputPayment();
        LottosIssuanceStrategy lottosIssuanceStrategy = new AutoLottosIssuanceStrategy();
        
        final int numberOfLottoPurchased = payment.countOfPurchasedLotto();
        final Lottos lottos = lottosIssuanceStrategy.issueLottos(numberOfLottoPurchased);
        
        OutputView.printLottoIssuanceResults(new LottosDTO(lottos));
        
        WinningLottoNumbers winningLottoNumbers = InputView.inputWinningLottoNumbers();
        final LottoRanksDTO lottoRanksDTO = new LottoRanksDTO(lottos, winningLottoNumbers);
    
        OutputView.printWinningStats(lottoRanksDTO);
    
        final double yield = payment.calculateYield(lottoRanksDTO.lottoRanks());
        OutputView.printYield(yield);
    }
}
