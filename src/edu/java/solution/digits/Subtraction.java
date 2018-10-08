package edu.java.solution.digits;

import edu.java.solution.lines.LineParsing;

/**
 * Выполняет вычитание двух чисел.
 */
public class Subtraction {

    /**
     * Выясняет, какой тип данных находится в строке, int или double.
     * Для вычислений использует перегруженный метод getSubtraction.
     *
     * @param digit1 Первая строка для проверки.
     * @param digit2 Вторая строка для проверки.
     * @return String Строка, содержащая число типа int или double.
     */
    public static String getSubtraction(String digit1, String digit2) {

        if (!digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getSubtraction(LineParsing.getIntFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (!digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getSubtraction(LineParsing.getIntFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }

        if (digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getSubtraction(LineParsing.getDoubleFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getSubtraction(LineParsing.getDoubleFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }
        return "";
    }

    /**
     * Выполняет вычитание двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа int.
     * @return double Результат вычитания двух чисел.
     */
    private static int getSubtraction(int digit1, int digit2) {
        return digit1 - digit2;
    }

    /**
     * Выполняет вычитание двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа double.
     * @return double Результат вычитания двух чисел.
     */
    private static double getSubtraction(int digit1, double digit2) {
        double digit = digit1 - digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет вычитание двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа int.
     * @return double Результат вычитания двух чисел.
     */
    private static double getSubtraction(double digit1, int digit2) {
        double digit = digit1 - digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет вычитание двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа double.
     * @return double Результат вычитания двух чисел.
     */
    private static double getSubtraction(double digit1, double digit2) {
        double digit = digit1 - digit2;
        return Round.getRound(digit);
    }
}
