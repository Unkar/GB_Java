//Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
//        Вывести название каждой планеты и количество его повторений в списке.
//Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.


import java.util.ArrayList;
import java.util.List;

public class CWTask2 {
    public static String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(planets[(int) (Math.random() * planets.length)]);
        }
        System.out.println(list);
        for (int i = 0; i < planets.length; i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (planets[i].equals(list.get(j))) {
                    count++;
                }
            }
            System.out.println(planets[i] + " " + count);
        }
        removeDuplicates(list);
        System.out.println(list);
    }

    public static void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }


}
