//4. \* К калькулятору из предыдущего дз добавить логирование.

import java.io.FileWriter;
import java.util.Scanner;

public class HWTask4 {

    public static void writeLog(String log) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(log);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double calculate(double a, double b, char operation) {
        StringBuilder log = new StringBuilder();
        double result = 0;
        switch (operation) {
            case '+' -> {
                result = a + b;
                log.append(a).append(" + ").append(b).append(" = ").append(result).append("\n");
            }
            case '-' -> {
                result = a - b;
                log.append(a).append(" - ").append(b).append(" = ").append(result).append("\n");
            }
            case '*' -> {
                result = a * b;
                log.append(a).append(" * ").append(b).append(" = ").append(result).append("\n");
            }
            case '/' -> {
                result = a / b;
                log.append(a).append(" / ").append(b).append(" = ").append(result).append("\n");
            }
            default -> System.out.println("Неверная операция");
        }
        writeLog(log.toString());
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        double a = scanner.nextDouble();
        System.out.println("Введите второе число");
        double b = scanner.nextDouble();
        System.out.println("Введите операцию");
        char operation = scanner.next().charAt(0);
        System.out.println("Результат: " + calculate(a, b, operation));
    }

}
