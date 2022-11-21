//3. Реализовать простой калькулятор
import  java.util.Scanner;

public class HWTask3 {
    public static double calculate(double a, double b, char operation) {
        double result = 0;
        switch (operation) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
            default -> System.out.println("Неверная операция");
        }
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
