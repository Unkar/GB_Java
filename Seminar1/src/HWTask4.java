//4. *+Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;

public class HWTask4 {


    public static String[] getNumbers(String str) {
        String[] numbers = new String[3];
        numbers[0] = str.substring(0, str.indexOf('+') - 1);
        numbers[1] = str.substring(str.indexOf('+') + 2, str.indexOf('=') - 1);
        numbers[2] = str.substring(str.indexOf('=') + 2);
        return numbers;
    }

    public static Integer getMaxLen(String[] numbers) {
        int maxLen = 0;
        for (String number : numbers) {
            if (number.length() > maxLen) {
                maxLen = number.length();
            }
        }
        return maxLen;
    }

    public static String[][] getDigits(String[] numbers, Integer maxLen) {
        String[][] digits = new String[3][maxLen];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < maxLen; j++) {
                if (numbers[i].length() - 1 - j >= 0) {
                    digits[i][j] = numbers[i].substring(numbers[i].length() - 1 - j, numbers[i].length() - j);
                } else {
                    digits[i][j] = " ";
                }
            }

        }
        return digits;
    }

    public static int[][] getDigitsInt(String[][] digits) {
        int[][] digitsInt = new int[3][digits[0].length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < digits[0].length; j++) {
                if (digits[i][j].equals("?") || digits[i][j].equals(" ")) {
                    digitsInt[i][j] = 0;
                } else {
                    digitsInt[i][j] = Integer.parseInt(digits[i][j]);
                }
            }
        }
        return digitsInt;
    }


    public static int[] getPreSolution(int[][] digitsInt, int maxLen) {
        int[] preSolution = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            preSolution[i] = digitsInt[2][i] - digitsInt[0][i] - digitsInt[1][i];
            if (preSolution[i] < 0) {
                preSolution[i] += 10;
                digitsInt[1][i + 1] += 1;
            }
        }
        return preSolution;
    }

//    public static boolean checkSolutionExist(String[][] digits, int[] preSolution) {
//        for (int i = 0; i < digits[0].length; i++) {
//            boolean isExist = false;
//            for (int j = 0; j < 3; j++) {
//                if (!digits[j][i].equals("?")) {
//                    isExist = true;
//                    break;
//                }
//            }
//            if (!isExist && preSolution[i] == 0) {
//                is\\\
//            }
//
//        return true;
//    }

    public static String[][] getSolution(int[] preSolution, String[][] digits, int maxLen) {
        for (int i = 0; i < maxLen; i++) {
            if (digits[0][i].equals("?") && digits[1][i].equals("?")) {
                digits[0][i] = String.valueOf(preSolution[i]);
                digits[1][i] = "0";
            } else if (digits[0][i].equals("?")) {
                digits[0][i] = String.valueOf(preSolution[i]);
            } else if (digits[1][i].equals("?")) {
                digits[1][i] = String.valueOf(preSolution[i]);
            }
        }
        return digits;
    }

    public static String getAnswer(String[][] digits, int maxLen) {
        String[] answer = new String[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = "";
            for (int j = 0; j < maxLen; j++) {
                if (digits[i][j] != null) {
                    answer[i] = digits[i][j] + answer[i];
                }
            }
        }
        return "%s + %s = %s".formatted(answer[0], answer[1], answer[2]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the equation:");
        String str = in.nextLine();
        String[] numbers = getNumbers(str);
        Integer maxLen = getMaxLen(numbers);
        String[][] digits = getDigits(numbers, maxLen);
        System.out.println("Разложение выражения по цифрам:");
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(digits[j][i] + " ");
            }
            System.out.println();
        }
        int[][] digitsInt = getDigitsInt(digits);
        int[] preSolution = getPreSolution(digitsInt, maxLen);
        System.out.println("Получаем предварительное решения в каких разрядах должны стоять какие числа:");
        for (int i = 0; i < maxLen; i++) {
            System.out.print(preSolution[i] + " ");
        }
        System.out.println();
        String[][] solution = getSolution(preSolution, digits, maxLen);
        System.out.println("Заполняем знаки вопроса соответственными значениями цифр из пререшения:");
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(solution[j][i] + " ");
            }
            System.out.println();
        }
        String answer = getAnswer(solution, maxLen);
        System.out.println(answer);
    }


}