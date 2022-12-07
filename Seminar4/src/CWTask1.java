//Реализовать консольное приложение, которое:
//        Принимает от пользователя строку вида
//        text~num
//        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//        Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

import java.util.LinkedList;
import java.util.Scanner;

public class CWTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        String input = scanner.nextLine();
        String[] inputArray = input.split("~");
        if (inputArray[0].equals("print")) {
            System.out.println(list.get(Integer.parseInt(inputArray[1])));
            list.remove(Integer.parseInt(inputArray[1]));
        } else {
            list.add(Integer.parseInt(inputArray[1]), inputArray[0]);
        }
    }
}
