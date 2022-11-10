package lotto.domain.validator;

public class NumberValidator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    
    public static boolean isOutOfRange(final Integer lottoNumber) {
        return lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER;
    }
}
