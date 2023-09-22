import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i ++) {
            number[i] = Integer.parseInt(br.readLine());
            sum += number[i];
            // ※ {1=1, -2=1, 2=1, 3=1, 8=1}
            map.put(number[i], map.getOrDefault(number[i], 0) + 1);
        }

        Arrays.sort(number);

        // ※ key만 있는 ArrayList 초기화
        List<Integer> keySet = new ArrayList<>(map.keySet());
        // ※ 내림차순 정렬
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        // ※ 가장 큰 key(= 입력받은 정수)를 저장
        int maxKey = keySet.get(0);

        // ※ 경우에 따라 최빈값 중 두 번째로 작은 값을 출력하기 위한 ArrayList
        ArrayList<Integer> same = new ArrayList<>();
        same.add(maxKey);

        for (int i = 1; i < keySet.size(); i ++) {
            // ※ maxKey의 value(빈도수)와 다음 key의 value(빈도수)가 같다면
            if (map.get(maxKey) == map.get(keySet.get(i))) {
                same.add(keySet.get(i));
            }
        }

        // ※ 최빈값을 찾기 위한 ArrayList 정렬
        Collections.sort(same);

        int mid = (number.length - 1) / 2;

        // ※ int / int -> float -> round() : -9 / 5 = -1 -> -1
        // ※ int / float -> round() : -9 / 5 = -1.8 -> -2 (부동 소수점 나눗셈)
        // ※ Math.round() : 소수점 이하 첫째 자리에서 반올림
        System.out.println(Math.round(sum / (float) n));
        // ※ 중앙값 : 오름차순으로 나열했을 경우, 중앙에 위치하는 값 -> 인덱스 기준
        System.out.println(number[mid]);
        System.out.println(same.size() > 1 ? same.get(1) : maxKey);
        // ※ 범위 : 최대값 - 최소값
        System.out.println(number[number.length - 1] - number[0]);

        br.close();
    }
}