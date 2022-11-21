//1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class HWTask1 {
    public static void sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.printf("Сумма чисел от 1 до %d равна %d%n", n, sum);
    }

    public static void factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.printf("Факториал числа %d равен %d%n", n, factorial);
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = in.nextInt();
        sum(n);
        factorial(n);


    }
}