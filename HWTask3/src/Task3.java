import java.util.ArrayList;
import java.util.List;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = getArray();
        list.forEach(System.out::println);
        System.out.println("Min: " + getMin(list));
        System.out.println("Max: " + getMax(list));
        System.out.println("Average: " + getAverage(list));
    }

    public static List<Integer> getArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer integer = (int) (Math.random() * 10);
            list.add(integer);
        }
        return list;
    }

    public static int getMin(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static double getAverage(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return (double) sum / list.size();
    }
}
