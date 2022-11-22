//4. *+Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;

public class HWTask4 {

    //    считываем вводимые значения и записываем в массив
    public static String[] getNumbers(String str) {
        String[] numbers = new String[3];
        numbers[0] = str.substring(0, str.indexOf('+') - 1);
        numbers[1] = str.substring(str.indexOf('+') + 2, str.indexOf('=') - 1);
        numbers[2] = str.substring(str.indexOf('=') + 2);
        return numbers;
    }

    // определяем максимальную длину числа
    public static Integer getMaxLen(String[] numbers) {
        int maxLen = 0;
        for (String number : numbers) {
            if (number.length() > maxLen) {
                maxLen = number.length();
            }
        }
        return maxLen;
    }

    // получаем массив чисел, где каждое число - это массив цифр
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

    // переводим массив цифр из строкового в числовой формат и знаки вопроса заменяем на 0
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

    // Ищем решение для каждого разряда числа
    // 2? + ?5 = 69 есть ни что иное как 2x + y5 = 69 ==> 25 + yx = 69 ==> yx = 44 ==> x = 4, y = 4
    // начинаем искать предварительное решение с самого младшего разряда
    // если в разряде разница меньше нуля, то переносим единицу в следующий разряд
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

    public static boolean checkSolutionExist(String[][] digits, int[] preSolution) {
        for (int i = 0; i < digits[0].length; i++) {
            if (!digits[0][i].equals("?") && !digits[1][i].equals("?") && preSolution[i] != 0) {
                if (Integer.parseInt(digits[0][i]) + Integer.parseInt(digits[1][i]) != preSolution[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    // Заполняем знаки вопрса в массиве цифр
    public static String[][] getSolution(int[] preSolution, String[][] digits, int maxLen) {
        for (int i = 0; i < maxLen; i++) {
            if (digits[0][i].equals("?") && digits[1][i].equals("?")) { // если в разряде 2 знака вопроса
                digits[0][i] = String.valueOf(preSolution[i]);  // то вставляем в него предварительное решение
                digits[1][i] = "0";                             // и вставляем 0 в другой разряд
            } else if (digits[0][i].equals("?")) {              // если в первом числе в разряде 1 знак вопроса
                digits[0][i] = String.valueOf(preSolution[i]);  // то вставляем в него предварительное решение
            } else if (digits[1][i].equals("?")) {              // если во втором числе в разряде 1 знак вопроса
                digits[1][i] = String.valueOf(preSolution[i]);  // то вставляем в него предварительное решение
            }
        }
        return digits;
    }

    //оформляем решение в виде строки
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
        System.out.println("\nПроверяем, что решение существует:");
        System.out.println(checkSolutionExist(digits, preSolution));
        if (checkSolutionExist(digits, preSolution)) {
            System.out.println("Получаем решение:");
            digits = getSolution(preSolution, digits, maxLen);
            for (int i = 0; i < maxLen; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(digits[j][i] + " ");
                }
                System.out.println();
            }
            System.out.println("Получаем ответ:");
            System.out.println(getAnswer(digits, maxLen));
        } else {
            System.out.println("Решение не существует");
        }
    }


}