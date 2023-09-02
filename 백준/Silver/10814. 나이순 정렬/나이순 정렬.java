import java.io.*;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<String>> map = new HashMap<>(); // ※ 다이아몬드 연산자

        for (int i = 0; i < n; i ++) {
            String[] member = br.readLine().split(" ");
            int age = Integer.parseInt(member[0]);
            String name = member[1];

            // ※ map의 key값으로 있다면 -> map.get(age) -> ArrayList<String> -> add(name)
            if (map.keySet().contains(age)) {
                map.get(age).add(name);
            } else { // ※ map의 value값으로 없다면
                // 1. ArrayList 형식인 value를 저장하기 위한 임시 ArrayList 선언
                ArrayList<String> tmp = new ArrayList<>();
                // 2. 임시 ArrayList에 value 저장
                tmp.add(name);
                // 3. Hashmap에 key(Integer)-value(ArrayList) 저장
                map.put(age, tmp);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (int k : keySet) {
            // ※ value를 하나씩 담을 ArrayList 선언
            ArrayList<String> list = map.get(k);
            for (int j = 0; j < list.size(); j ++) {
                // key 당 모든 value를 출력 후, 다음 key 값에 대해 value를 출력
                System.out.println(k + " " + list.get(j));
            }
        }
    }
}