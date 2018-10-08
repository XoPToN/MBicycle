package edu.java.solution.lines;

/**
 * класс,который разбирает входящую строку
 */

public class LineParsing {

    /**
     * метод, убирающий из строки лидирующий "-" и возвращающий результат
     * работы метода getSymbolLine
     *
     * @param line - входящая строка для обработки
     * @return mathOperator - строку содержащую символ математического оператора: (* / + -)
     */

    public static String getFirstSymbol(String line) {
        line = line.startsWith("-") ? line.substring(1) : line;
        if (line.contains("*") || line.contains("/")) {
            return getSymbolLine(line, 1);
        } else {
            if (line.contains("+") || line.contains("-")) {
                return getSymbolLine(line, 2);
            }
        }
        return "";
    }


    /**
     * метод, выбирающий из строки приоритетный математический оператор /*+-
     *
     * @param line     - строка содержащая математическое выражение
     * @param priority - приоритет, на основе которого выбирается математический оператор (
     *                 1  - если умножение или деление и  2 - если сложение или вычитание)
     * @return mathOperator - строка содержащая первый найденный математический оператор
     * с учетом приоритета
     */
    private static String getSymbolLine(String line, int priority) {
        String mathOperator = "";
        char[] lineArray = line.toCharArray();
        if (priority == 1) {
            for (int f = 0; f < lineArray.length; f++) {
                if (lineArray[f] == '*' || lineArray[f] == '/') {
                    mathOperator += lineArray[f];
                    break;
                }
            }

        } else if (priority == 2) {
            for (int f = 0; f < lineArray.length; f++) {
                if (lineArray[f] == '+' || lineArray[f] == '-') {
                    mathOperator += lineArray[f];
                    break;
                }
            }
        }

        return mathOperator;
    }

    /**
     * метод, находящий число левее матеметического оператора: /*-+
     *
     * @param line       строка, содержащая математическое выражение
     * @param coordinate - координата математического оператора
     * @return DigitToBegin - число левее математического оператора в виде строки
     */
    public static String getDigitToBegin(String line, int coordinate) {
        String DigitToBegin = "";
        char[] lineArray = line.toCharArray();
        for (int f = coordinate - 1; f >= 0; f--) {
            if (Character.isDigit(lineArray[f]) | lineArray[f] == '.' | lineArray[f] == '-') {
                DigitToBegin = lineArray[f] + DigitToBegin;
            } else {
                break;
            }
        }

        return DigitToBegin;
    }

    /**
     * метод, находящий число правее матеметического оператора: /*-+
     *
     * @param line       строка, содержащая математическое выражение
     * @param coordinate - координата математического оператора
     * @return DigitToBegin - число правее математического оператора в виде строки
     */
    public static String getDigitToEnd(String line, int coordinate) {
        String DigitToEnd = "";
        char[] lineArray = line.toCharArray();
        for (int f = coordinate + 1; f < lineArray.length; f++) {
            if (Character.isDigit(lineArray[f]) | lineArray[f] == '.') {
                DigitToEnd += lineArray[f];
            } else {
                break;
            }
        }

        return DigitToEnd;
    }

    /**
     * метод, получающий строку и возращающий дробное число
     *
     * @param line - входящая строка, содержащая только цифры и .
     * @return - дробное число, преобразованное из строки
     */
    public static double getDoubleFromLine(String line) {
        return Double.parseDouble(line);

    }

    /**
     * метод, получающий строку и возращающий целое число
     *
     * @param line - входящая строка, содержащая только цифры.
     * @return - целое число, преобразованное из строки
     */

    public static int getIntFromLine(String line) {
        return Integer.parseInt(line);
    }
}

