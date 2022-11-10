package lotto.domain;

import lotto.domain.validator.BonusNumberValidator;

public class WinningLottoNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;
    
    public WinningLottoNumbers(final Lotto winningLotto, final int bonusNumber) {
        validateBonusNumber(bonusNumber);
        
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    
    private void validateBonusNumber(final int bonusNumber) {
        BonusNumberValidator.validate(bonusNumber);
    }
    
    public int countOfMatchingNumber(final Lotto lotto) {
        return lotto.countOfMatchingNumber(winningLotto);
    }
    
    public boolean isBonusNumberExist(final Lotto lotto) {
        return lotto.isNumberContains(bonusNumber);
    }
}
