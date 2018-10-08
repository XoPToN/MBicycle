package edu.java.solution.lines;

/**
 * класс, обрабатывает входящую строку  и возвращает строку,
 * в корректном для математических вычислений виде
 */
public class LineCheck {

    /**
     * метод, возвращающий результаты работы других  методов
     *
     * @param line - входящая строка для обработки
     * @return работу метода isCommaExist и getSymbolsRight
     */

    public static boolean getLineCheck(String line) {
        return isCommaExist(line) & getSymbolsRight(line);
    }

    /**
     * метод, проверяет на содержание в строке открывающих или закрывающих скобок
     *
     * @param line - входящая строка для обработки
     * @return работу метода getCommasCount или false
     */

    public static boolean isCommaExist(String line) {
        return line.contains("(") || line.contains(")") ? getCommasCount(line) : false;
    }

    /**
     * метод, определяющий, содержит ли строка равное количество открывающих или закрывающих скобок
     *
     * @param line - входящая строка для обработки
     * @return работу метода getCommasRight или false
     */
    public static boolean getCommasCount(String line) {

        int openingBrackets = 0;
        int closingBrackets = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                openingBrackets++;
            } else if (line.charAt(i) == ')') {
                closingBrackets++;
            }
        }
        return openingBrackets == closingBrackets ? getCommasRight(line) : false;
    }

    /**
     * метод, проверят на правильность растановки скобок в строке
     *
     * @param line - входящая строка для обработки
     * @return boolean
     */
    public static boolean getCommasRight(String line) {
        if (line.indexOf(")") < line.indexOf("(")) {
            return false;
        } else if (line.lastIndexOf("(") > line.lastIndexOf(")")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * метод, возращающий, результат работы методов getSymbolsRight и getSymbolFirst для символов +-/*
     *
     * @param line - входящая строка для обработки
     * @return работу методов getSymbolFirst  и getSymbolEnd
     */
    public static boolean getSymbolsRight(String line) {

        return getSymbolFirst(line, "*") && getSymbolEnd(line, "*")
                && getSymbolFirst(line, "/") && getSymbolEnd(line, "/")
                && getSymbolEnd(line, "+")
                && getSymbolEnd(line, "-");
    }

    /**
     * метод, определяющий, начинается ли строка line с символа указанного  в строке symbol
     *
     * @param line   - математическое уравнение
     * @param symbol - строка, содержащая символ на наличие которого нужно проверить
     * @return инвертированный boolean
     */
    public static boolean getSymbolFirst(String line, String symbol) {
        return !line.startsWith(symbol);
    }

    /**
     * метод, определяющий, заканчивается ли строка line с символа указанного в строке symbol
     *
     * @param line   - математическое уравнение
     * @param symbol - строка, содержащая символ на наличие которого нужно проверить
     * @return инвертированный boolean
     */
    public static boolean getSymbolEnd(String line, String symbol) {
        return !line.endsWith(symbol);
    }
}
