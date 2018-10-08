package edu.java.solution;

import edu.java.solution.lines.LineOperation;
import edu.java.solution.lines.LinePreparing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Вводите ваше математическое выражение ");
        Scanner inputString = new Scanner(System.in);
        String str = inputString.nextLine();
        System.out.println(LinePreparing.getLinePrepared(str));
        System.out.println(LineOperation.getResult(str));

    }
}
