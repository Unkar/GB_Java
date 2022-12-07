//Заполнить список десятью случайными числами.
//        Отсортировать список методом sort() и вывести его на экран.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CWTask1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
