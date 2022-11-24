//#aaaaabbbbbbcccccccccdddddddddddeeeeeeeeeeffffffffffggggggggggg ->abcdefg


public class CWTask2 {
    public static String getZipString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sb.append(s.charAt(i));
                sb.append(count);
            } else if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getZipString("aaaaabbbbbbcccccccccdddddddddddeeeeeeeeeeffffffffffggggggggggg"));
    }
}
