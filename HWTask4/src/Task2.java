import java.util.LinkedList;
import java.util.List;

//Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class Task2 {
    public static List<Integer> getRandList(int size) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }

    public static List<Integer> enqueue(List<Integer> list, int element) {
        list.add(element);
        return list;
    }

    public static int dequeue(List<Integer> list) {
        int element = list.get(0);
        list.remove(0);
        return element;
    }

    public static int first(List<Integer> list) {
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> list = getRandList(10);
        System.out.println(list);
        System.out.println(enqueue(list, 100));
        System.out.println(dequeue(list));
        System.out.println(first(list));
    }
}
