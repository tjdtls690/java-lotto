package lotto.domain.validator;

import lotto.domain.Lotto;

public class BonusNumberValidator extends NumberValidator {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1~45의 범위를 벗어날 수 없습니다.";
    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 이미 존재하는 번호입니다.";
    
    private BonusNumberValidator() {
        throw new IllegalStateException(ValidatorExceptionMessageConstants.UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static void validate(final Lotto winningLotto, final int bonusNumber) {
        validateOutOfRange(bonusNumber);
        validateDuplicateLottoNumber(winningLotto, bonusNumber);
    }
    
    private static void validateOutOfRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private static void validateDuplicateLottoNumber(final Lotto winningLotto, final int bonusNumber) {
        if (winningLotto.isNumberContains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
