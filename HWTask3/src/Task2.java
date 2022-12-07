import java.util.ArrayList;
import java.util.List;

//Пусть дан произвольный список целых чисел, удалить из него четные числа
//и вывести результат на экран.
public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = getArray();
        list.forEach(System.out::println);
        removeEvenNumbers(list);
        list.forEach(System.out::println);
    }

    public static List<Integer> getArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer integer = (int) (Math.random() * 10);
            list.add(integer);
        }
        return list;
    }

    public static void removeEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Removed even numbers");
    }

}
