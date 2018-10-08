package edu.java.solution.lines;

import edu.java.solution.digits.Addition;
import edu.java.solution.digits.Division;
import edu.java.solution.digits.Multiplication;
import edu.java.solution.digits.Subtraction;


/**
 * Выполняет арифметические расчёты с числами.
 */

public class LineOperation {


    /**
     * Производит конкатинацию двух строк
     *
     * @param oldLine
     * @param newLine
     * @return результат конкатинации str1,str1
     */
    public static String getNewLine(String oldLine, String newLine) {
        String lineConcat = oldLine + newLine;
        //пока не ясно, что сюда приходит
        return lineConcat;
    }


    /**
     * 1. Записывает в строку line результат работы метода LinePreparing.getLinePreparing
     * 2. если метод LineCheck.getLineChek вернул true  выполнит пункт 3,если нет ,вернет строку
     * 3. если строка содержит символы "(" или ")", возвращает результат работы метода
     * getResultWithCommas ,в противном случае,вернет результат работы метода
     * getResultWithoutCommas
     *
     * @param str
     * @return результат выражения
     */
    public static String getResult(String str) {
        String line = LinePreparing.getLinePrepared(str);
        if (LineCheck.getLineCheck(str)) {
            line = LineOperation.getResultWithCommas(line);
        } else {
            line = LineOperation.getResultWithoutCommas(line);
        }
        return line;
    }

    /**
     * 1. Поиск последнего вхождения символа "("(далее coord) и после него первого вхождения ")"(coord1)
     * после чего находит строку между этими символами
     * 2. Производит подготовку подготовку строки в методе LinePreparing ,
     * после, отправляет в метод getResultWithoutCommas
     * 3.workLine, inBrackets, coord, coord1 отправляет в метод getLineCollected
     * для обработки до полного исчезнавения символа "(" и ")"
     * полученую строку в !(итоге) отправляет в метод getResultWithoutCommas
     *
     * @param line
     * @return результат выражения,если есть скобки
     */
    private static String getResultWithCommas(String line) {

        String workLine = line;
        while (workLine.contains("(")) {

            int coordLeft = workLine.lastIndexOf("(");          //координата скобки (
            int coordRight = workLine.indexOf(")", coordLeft);      //координата скобки )
            String inBrackets = workLine.substring(coordLeft + 1, coordRight);//строка в скобках
            inBrackets = LinePreparing.getLinePrepared(inBrackets);
            String with = LineOperation.getResultWithoutCommas(inBrackets);       // результат
            workLine = LineOperation.getLineCollected(workLine, with, coordLeft, coordRight);
            //обрабатывает строку до полного исчезнавения символов "(" ")"
        }
        workLine = LineOperation.getResultWithoutCommas(workLine);
        return workLine;
    }


    /**
     * Пока строка содержит символы /, +, -, *
     * проверяет является ли строка числом(целое, дробное, отрицательное, положительное) после
     * получает первый символ с помошью метода LineParsing.getFirstSymbol и
     * записывает координату этого символа.
     * В зависимости от того какой это символ вызывает метод
     * getResultAddition если +,
     * getResultDivision если /,
     * getResultMultipliсation если *,
     * getResultSubtraction если -,
     * а переменная result содержит результат рабомы этих методов.
     * В итоговую строку записывает результат работы метода getLineCollected.
     * Если в строке встречается "--" заменяет на "+".
     * Если в строке есть символ точки,но после этого символа идут нули,то
     * вернет только ту часть строки,которая находится левее символа точки
     *
     * @param line
     * @return Результат выражения
     */
    private static String getResultWithoutCommas(String line) {
        //является ли строка числом
        String workLine = line;
        while (workLine.contains("+") |
                workLine.contains("-") |
                workLine.contains("*") |
                workLine.contains("/")) {
            String result = "";

            if (isFinalDigit(workLine)) {
                // приоритетный символ
                String symbol = LineParsing.getFirstSymbol(workLine);
                //координата символа
                int coordSymbol = LineOperation.getSymbolCoord(workLine, symbol);

                if (symbol.contains("*")) {
                    result = LineOperation.getResultMultipliсation(workLine, coordSymbol);
                }
                if (symbol.contains("/")) {
                    result = LineOperation.getResultDivision(workLine, coordSymbol);
                }
                if (symbol.contains("+")) {
                    result = LineOperation.getResultAddition(workLine, coordSymbol);
                }
                if (symbol.contains("-")) {
                    result = LineOperation.getResultSubtraction(workLine, coordSymbol);
                }
                if (result.contains("--")) {
                    result = result.replace("--", "+");
                }
                workLine = LineOperation.getLineCollected(workLine, result, coordSymbol);
            }

            String lineEnd = workLine.substring(workLine.indexOf(".") + 1, workLine.length());
            String resultEnd = "";
            char[] lineArray = lineEnd.toCharArray();
            for (int f = 0; f < lineEnd.length(); f++) {
                if (lineArray[f] == '0') {
                    resultEnd = lineArray[f] + resultEnd;
                } else {
                    break;
                }
            }
            if (!workLine.equalsIgnoreCase("0") &&
                    lineEnd.length() == resultEnd.length()) {
                workLine = workLine.substring(0, workLine.indexOf("."));
            } else {
                workLine = workLine;
            }

        }
        return workLine;
    }

    /**
     * Находит координату символа
     *
     * @param line   строка с математическим выражением
     * @param symbol символ + - * /
     * @return координату первого вхождения указаного символа
     */
    private static int getSymbolCoord(String line, String symbol) {
        int coordSymbol;
        if (line.startsWith("-")) { // без проверки на первый минус не правильно находит координату символа Мигутская
            line = line.substring(1);
            coordSymbol = line.indexOf(symbol) + 1;
        } else {
            line = line.substring(0);
            coordSymbol = line.indexOf(symbol);
        }
        return coordSymbol;
    }

    /**
     * получает строку в переменной left содержащую число левее от символа
     * так же строку в переменной right содержащую число правее от символа
     * с помощь переменных left right возвращает результат работы метода Addition.getAddition()
     *
     * @param line        строка с матиматическим выражением
     * @param coordSymbol координата символа
     * @return Добыть результат сложения
     */
    private static String getResultAddition(String line, int coordSymbol) {

        String left = LineParsing.getDigitToBegin(line, coordSymbol);
        String right = LineParsing.getDigitToEnd(line, coordSymbol);
        String result = Addition.getAddition(left, right);

        return result;
    }

    /**
     * получает строку в переменной left содержащую число левее от символа
     * так же строку в переменной right содержащую число правее от символа
     * с помощь переменных left right возвращает результат работы метода Division.getDivision()
     *
     * @param line        строка с матиматическим выражением
     * @param coordSymbol координата символа
     * @return Результат деления
     */
    private static String getResultDivision(String line, int coordSymbol) {

        String left = LineParsing.getDigitToBegin(line, coordSymbol);
        String right = LineParsing.getDigitToEnd(line, coordSymbol);
        String result = Division.getDivision(left, right);
        return result;
    }

    /**
     * получает строку в переменной left содержащую число левее от символа,
     * так же строку в переменной right содержащую число правее от символа,
     * с помощь переменных left right возвращает результат работы метода Multiplication.getMultiplication(
     *
     * @param line        строка с матиматическим выражением
     * @param coordSymbol координата символа
     * @return Результат умножения
     */
    private static String getResultMultipliсation(String line, int coordSymbol) {

        String left = LineParsing.getDigitToBegin(line, coordSymbol);
        String right = LineParsing.getDigitToEnd(line, coordSymbol);
        String result = Multiplication.getMultiplication(left, right);
        return result;
    }

    /**
     * получает строку в переменной left содержащую число левее от символа
     * так же строку в переменной right содержащую число правее от символа
     * с помощь переменных left right возвращает результат работы метода Subtraction.getSubtraction()
     *
     * @param line        строка с матиматическим выражением
     * @param coordSymbol координата символа
     * @return Результат разности
     */
    private static String getResultSubtraction(String line, int coordSymbol) {

        String left = LineParsing.getDigitToBegin(line, coordSymbol);
        String right = LineParsing.getDigitToEnd(line, coordSymbol);
        String result = Subtraction.getSubtraction(left, right);
        return result;
    }

    /**
     * Получает строку c числом левее от символа,
     * строку с числом правее от символа,
     * часть строки (1) до левого числа,
     * часть строки (2)от правого числа
     * Складывает (1) + result + (2)
     *
     * @param line        строка с матиматическим выражением
     * @param result      строка результата отдельного выражения(результат)
     * @param coordSymbol координата символа
     * @return левая строка до числа + результат + правая строка от числа
     */
    private static String getLineCollected(String line, String result, int coordSymbol) {
        // левое и правое число от символа
        String digitLeft = LineParsing.getDigitToBegin(line, coordSymbol);
        String digitRight = LineParsing.getDigitToEnd(line, coordSymbol);
        //левая и правая строка от числа
        String lineLeft = line.substring(0, line.indexOf(digitLeft));
        String lineRight = line.substring(line.indexOf(digitRight, coordSymbol)
                + digitRight.length(), line.length());

        String lineResult = lineLeft + result + lineRight;
        return lineResult;
    }

    /**
     * Метод собирает строку из трех переменых,
     * переменная lineLeft  часть строки до символа "("
     * переменная lineRight  часть строки после символа")"
     * переменная sum результат выражения в скобках
     *
     * @param line
     * @param sum        результат выражения в скобках
     * @param coordLeft  координата символа скобки "("
     * @param coordRight координат символа скобки ")"
     * @return строка до символа "(" + результат отдельного выражения + строка после сивола ")"
     */
    private static String getLineCollected(String line, String sum, int coordLeft, int coordRight) {
        //левая и правая
        String lineLeft = line.substring(0, coordLeft);
        String lineRight = line.substring(coordRight + 1, line.length());
        //сложение строк. sum - результат выражения в скобках
        String workline = lineLeft + sum + lineRight;
        return workline;
    }

    /**
     * В строке line могут присудствовать только следующие символы :0123456789./*+-
     * в противном случае вернет false
     *
     * @param line
     * @return true если число
     */
    private static boolean isFinalDigit(String line) {
        String result = "";
        char[] lineArray = line.toCharArray();

        for (int f = 0; f < line.length(); f++) {
            if (Character.isDigit(lineArray[f]) |
                    lineArray[f] == '+' |
                    lineArray[f] == '-' |
                    lineArray[f] == '*' |
                    lineArray[f] == '/' |
                    lineArray[f] == '.') {
                result = lineArray[f] + result;
            } else {
                break;
            }
        }
        if (line.length() == result.length()) {
            return true;
        } else {
            return false;
        }
    }
}