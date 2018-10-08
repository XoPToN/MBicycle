package edu.java.solution.digits;

import edu.java.solution.lines.LineParsing;

/**
 * Выполняет умножение двух чисел.
 */
public class Multiplication {


    /**
     * Выясняет, какой тип данных находится в строке, int или double.
     * Для вычислений использует перегруженный метод getMultiplication.
     *
     * @param digit1 Первая строка для проверки.
     * @param digit2 Вторая строка для проверки.
     * @return String Строка, содержащая число типа int или double.
     */
    public static String getMultiplication(String digit1, String digit2) {

        if (!digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getMultiplication(LineParsing.getIntFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (!digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getMultiplication(LineParsing.getIntFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }

        if (digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getMultiplication(LineParsing.getDoubleFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getMultiplication(LineParsing.getDoubleFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }
        return "";
    }

    /**
     * Выполняет умножение двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа int.
     * @return double Результат умножения двух чисел.
     */
    private static double getMultiplication(int digit1, int digit2) {
        double digit = digit1 * digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет умножение двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа double.
     * @return double Результат умножения двух чисел.
     */
    private static double getMultiplication(int digit1, double digit2) {
        double digit = digit1 * digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет умножение двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа int.
     * @return double Результат умножения двух чисел.
     */
    private static double getMultiplication(double digit1, int digit2) {
        double digit = digit1 * digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет умножение двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа double.
     * @return double Результат умножения двух чисел.
     */
    private static double getMultiplication(double digit1, double digit2) {
        double digit = digit1 * digit2;
        return Round.getRound(digit);
    }
}
