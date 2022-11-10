package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
    }
    
    public int countOfSameNumber(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containsNumber)
                .count();
    }
    
    public boolean containsNumber(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
