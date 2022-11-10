package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),;
    
    private final int countOfSameLottoNumber;
    private final int prizeMoney;
    
    LottoRank(final int countOfSameLottoNumber, final int prizeMoney) {
        this.countOfSameLottoNumber = countOfSameLottoNumber;
        this.prizeMoney = prizeMoney;
    }
    
    public static LottoRank parseRank(final int countOfSameLottoNumber, final boolean existBonusLottoNumber) {
        if (isSecondRank(countOfSameLottoNumber, existBonusLottoNumber)) {
            return SECOND;
        }
        
        return Arrays.stream(values())
                .filter(Predicate.not(LottoRank::isSecond))
                .filter(lottoRank -> isCountOfSameLottoNumberSame(lottoRank, countOfSameLottoNumber))
                .findAny()
                .orElse(MISS);
    }
    
    private static boolean isSecondRank(final int countOfSameLottoNumber, final boolean existBonusLottoNumber) {
        return isCountOfMatchingLottoNumberSame(SECOND, countOfSameLottoNumber) && existBonusLottoNumber;
    }
    
    private boolean isSecond() {
        return this == SECOND;
    }
    
    private static boolean isCountOfSameLottoNumberSame(final LottoRank lottoRank, final int countOfSameLottoNumber) {
        return isCountOfMatchingLottoNumberSame(lottoRank, countOfSameLottoNumber);
    }
    
    private static boolean isCountOfMatchingLottoNumberSame(final LottoRank second, final int countOfSameLottoNumber) {
        return second.countOfSameLottoNumber == countOfSameLottoNumber;
    }
    
    public int prizeMoney() {
        return prizeMoney;
    }
}
