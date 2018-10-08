package edu.java.solution.digits;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Выполняет округление до двух знаков после точки.
 */

public class Round {
    /**
     * Количество знаков после точки
     */
    private static final int SCALE_SIZE = 2;

    /**
     * Возвращает число с округлением.
     *
     * @param digit Входящее double число для округления.
     * @return double Число после округления.
     */
    public static double getRound(double digit) {
        return new BigDecimal(digit).setScale(SCALE_SIZE, RoundingMode.HALF_UP).doubleValue();
    }
}
