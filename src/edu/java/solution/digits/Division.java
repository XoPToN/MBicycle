package edu.java.solution.digits;


import edu.java.solution.lines.LineParsing;

/**
 * Выполняет деление двух чисел.
 */
public class Division {

    /**
     * Выясняет, какой тип данных находится в строке, int или double.
     * Для вычислений использует перегруженный метод getDivision.
     *
     * @param digit1 Первая строка для проверки.
     * @param digit2 Вторая строка для проверки.
     * @return String Строка, содержащая число типа int или double.
     */
    public static String getDivision(String digit1, String digit2) {

        if (!digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getDivision(LineParsing.getIntFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (!digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getDivision(LineParsing.getIntFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }

        if (digit1.contains(".") & !digit2.contains(".")) {
            return String.valueOf
                    (getDivision(LineParsing.getDoubleFromLine(digit1), LineParsing.getIntFromLine(digit2)));
        }

        if (digit1.contains(".") & digit2.contains(".")) {
            return String.valueOf
                    (getDivision(LineParsing.getDoubleFromLine(digit1), LineParsing.getDoubleFromLine(digit2)));
        }
        return "";
    }

    /**
     * Выполняет деление двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа int.
     * @return double Результат сложения двух чисел.
     */
    private static double getDivision(int digit1, int digit2) {
        double digit = (double) digit1 / digit2; // перевела int в double Мигутская
        return Round.getRound(digit);
    }

    /**
     * Выполняет деление двух чисел.
     *
     * @param digit1 Первое число типа int.
     * @param digit2 Первое число типа double.
     * @return double Результат деления двух чисел.
     */
    private static double getDivision(int digit1, double digit2) {
        double digit = digit1 / digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет деление двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа int.
     * @return double Результат деления двух чисел.
     */
    private static double getDivision(double digit1, int digit2) {
        double digit = digit1 / digit2;
        return Round.getRound(digit);
    }

    /**
     * Выполняет деление двух чисел.
     *
     * @param digit1 Первое число типа double.
     * @param digit2 Первое число типа double.
     * @return double Результат деления двух чисел.
     */
    private static double getDivision(double digit1, double digit2) {
        double digit = digit1 / digit2;
        return Round.getRound(digit);
    }
}
