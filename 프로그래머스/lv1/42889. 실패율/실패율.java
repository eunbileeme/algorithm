import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double clear = 0;
        int tot_clear = 0;

        HashMap<Integer, Double> map = new HashMap<>();

        // i : stage의 길이
        for (int i = 1; i < (N + 1); i++) {
            // j : stage의 element
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    clear++;
                }
               
                if (i <= stages[j]) {
                    tot_clear++;
                }
            }
            map.put(i, clear / ((tot_clear == 0) ? 1 : tot_clear));

            clear = 0;
            tot_clear = 0;
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        return keySet.stream().mapToInt(i -> i).toArray();
    }
}