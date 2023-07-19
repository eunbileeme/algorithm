import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < name.length; i ++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i ++) {
            for (int j = 0; j < photo[i].length; j ++) {
                if (map.containsKey(photo[i][j]))
                    answer += map.get(photo[i][j]);
            }
            
            list.add(answer);
            answer = 0;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}