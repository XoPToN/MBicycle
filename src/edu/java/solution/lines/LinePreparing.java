package edu.java.solution.lines;

/**
 * класс, обрабатывает входящую строку и возвращает строку,
 * содержащую только 0123456789.()+/-* без пробелов, дублированных знаков
 * и лишних символов в начале и конце строки
 */
public class LinePreparing {
    /**
     * метод, возвращающий  результаты последовательной работы  методов getLineWithoutSpaces(String line),
     * getLineReplaceCommas(String line), getLineReplaceDouble(String line),
     * getLineWithoutLetters(String line)
     *
     * @param line String
     * @return String после обработки другими методами
     */
    public static String getLinePrepared(String line) {
        if (line.isEmpty()) {
            return line + "Пустая строка";
        }
        return getLineWithoutLetters(getLineReplaceDouble(getLineReplaceCommas(getLineWithoutSpaces(line))));
    }


    /**
     * метод, возвращающий пришедшую строку без пробелов
     *
     * @param line String
     * @return String без пробелов
     */
    private static String getLineWithoutSpaces(String line) {
        return line.replaceAll("\\s", "");
    }

    /**
     * метод, возвращающий пришедшую строку, в которой все запятые заменены на точки
     *
     * @param line String
     * @return String, после замены всех ',' на '.'
     */
    private static String getLineReplaceCommas(String line) {
        return line.replaceAll(",+", ".");
    }

    /**
     * метод, возвращающий строку,
     * в которой все дубликаты (+-/*) заменены на единичные
     *
     * @param line String
     * @return result String без дублирующих знаков (+-/*)
     */
    private static String getLineReplaceDouble(String line) {
        String resultM = "";
        String result = line.replaceAll("\\++", "+");
        result = result.replaceAll("\\*\\*+", "*");
        result = result.replaceAll("/+", "/");
        result = result.replaceAll("\\.+", ".");
        if (result.contains("-?\\d")) {
            resultM = result;
        }
        result = result.replaceAll("\\-\\-\\-", " -");
        result = result.replaceAll("\\-\\-", " +");
        return result;
    }

    /**
     * метод, возвращающий пришедшую строку, содержащую только допустимые символы 0123456789.()+/-*
     *
     * @param line String
     * @return String, как результат работы метода getLineCorrect(line)
     */
    /**
     * оставляет в строке только допустимые символы
     *
     * @param line строка
     * @return результат работы метода getLineCorrect
     */
    private static String getLineWithoutLetters(String line) {
        char[] chArray = line.toCharArray();
        String result = "";
        for (int i = 0; i < chArray.length; i++) {
            if (Character.isDigit(chArray[i]) | chArray[i] == '.' | chArray[i] == '(' | chArray[i] == ')' |
                    chArray[i] == '*' | chArray[i] == '/' | chArray[i] == '+' | chArray[i] == '-') {
                result += chArray[i];
            }
        }
        return result = getLineCorrect(result);
    }

    /**
     * удалят из строки лишние символы в начале и в конце строки
     *
     * @param line строка
     * @return result строка
     */
    private static String getLineCorrect(String line) {
        char[] chArray = line.toCharArray();
        String result = "";
        int coordFirstDigit = 0;
        int coordLastDigit = 0;
        for (int i = 0; i < chArray.length; i++) {
            if (Character.isDigit(chArray[i])|| chArray[i] == '(') {
                if (i > 0 && chArray[i - 1] == '-') {
                    coordFirstDigit = i - 1;
                } else {
                    coordFirstDigit = i;
                }
                break;
            }
        }
        for (int i = chArray.length - 1; i >= 0; i--) {
            if (Character.isDigit(chArray[i]) || chArray[i] == ')') {
                coordLastDigit = i;
                break;
            }
        }
        return result = line.substring(coordFirstDigit, coordLastDigit + 1);
    }
}
