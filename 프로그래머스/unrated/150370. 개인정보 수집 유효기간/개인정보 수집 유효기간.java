import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        // terms("A 6")
        for (int i = 0; i < terms.length; i ++) {
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        // today
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        
        // privacies
        for (int i = 0; i < privacies.length; i ++) {
            // "2021.05.02"
            String date = privacies[i].split(" ")[0];
            // "A"
            int type = Integer.parseInt(map.get(privacies[i].split(" ")[1])) * 28;
            
            // today - privacies (일수로 계산)
            int num = (year - Integer.parseInt(date.split("\\.")[0])) * 28 * 12
                + (month - Integer.parseInt(date.split("\\.")[1])) * 28
                + (day - Integer.parseInt(date.split("\\.")[2]));
            
            // 유효기간(type) 보다 오늘 날짜와 개인정보 수집 일자로부터의 차이(num)가 크다면
            // 유효기간을 지난 것으로 파기해야 함
            if (num >= type) {
                list.add(i + 1);
            }
        }
        
        return list.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}