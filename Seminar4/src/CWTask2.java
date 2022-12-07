//Реализовать консольное приложение, которое:
//        Принимает от пользователя и “запоминает” строки.
//        Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//        Если введено revert, удаляет предыдущую введенную строку из памяти.

import java.util.ArrayList;
import java.util.Scanner;

public class CWTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("print") && !input.equals("revert")) {
            list.add(input);
            input = scanner.nextLine();
        }
        if (input.equals("print")) {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        } else if (input.equals("revert")) {
            list.remove(list.size() - 1);
        }
    }
}
