import java.util.LinkedList;
import java.util.List;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class Task1 {
    public static List<Integer> getRandList(int size) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }

    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> list = getRandList(10);
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}
