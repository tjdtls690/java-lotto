package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    
    public <E> Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public List<LottoRank> parseRanks(final WinningLottoNumbers winningLottoNumbers) {
        return lottos.stream()
                .map(lotto -> parseRank(winningLottoNumbers, lotto))
                .collect(Collectors.toList());
    }
    
    private LottoRank parseRank(final WinningLottoNumbers winningLottoNumbers, final Lotto lotto) {
        int countOfSameLottoNumber = winningLottoNumbers.countOfMatchingNumber(lotto);
        boolean existBonusLottoNumber = winningLottoNumbers.isBonusNumberExist(lotto);
        
        return LottoRank.parseRank(countOfSameLottoNumber, existBonusLottoNumber);
    }
}
