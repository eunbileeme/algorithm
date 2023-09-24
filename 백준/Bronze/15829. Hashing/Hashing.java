import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 문자열의 길이
        String[] str = br.readLine().split("");

        HashMap<String, Integer> map = new HashMap<>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
            put("d", 4);
            put("e", 5);
            put("f", 6);
            put("g", 7);
            put("h", 8);
            put("i", 9);
            put("j", 10);
            put("k", 11);
            put("l", 12);
            put("m", 13);
            put("n", 14);
            put("o", 15);
            put("p", 16);
            put("q", 17);
            put("r", 18);
            put("s", 19);
            put("t", 20);
            put("u", 21);
            put("v", 22);
            put("w", 23);
            put("x", 24);
            put("y", 25);
            put("z", 26);
        }};

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < str.length; i ++) {
            hash += (map.get(str[i]) * pow) % 1234567891;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(hash % 1234567891);

        br.close();
    }
}