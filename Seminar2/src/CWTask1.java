//#Дано чётное число n и символы с1 и с2. Напечатать строку длины n, состоящую из символов с1 и с2,
//#причём сначала идёт с1, затем с2, затем с1, затем с2 и т.д. (например, n=6, с1=’a’, с2=’b’,


public class CWTask1 {
    public static String makeString(char c1, char c2, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append(c1);
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeString('a', 'b', 6));
    }
}
