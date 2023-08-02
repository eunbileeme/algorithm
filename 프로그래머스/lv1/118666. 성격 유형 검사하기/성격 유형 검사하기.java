// survey : 질문마다 판단하는 지표 (["AN"])
// choices : 각 질문마다 선택한 선택지([5])
// 지표가 포함되지 않은 경우는 자연스럽게 0점
// 두 유형 중 하나를 어떻게 효율적으로 작성할 수 없을까?

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String result = "";
        int r = 0;
        int t = 0;
        int c = 0;
        int f = 0;
        int j = 0;
        int m = 0;
        int a = 0;
        int n = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(1, 3);
            put(2, 2);
            put(3, 1);
            put(4, 0);
            put(5, 1);
            put(6, 2);
            put(7, 3);
        }};
        
        for (int i = 0; i < survey.length; i ++) {
            String c1 = String.valueOf(survey[i].charAt(0));
            String c2 = String.valueOf(survey[i].charAt(1));
            if (choices[i] < 4) {
                if (c1.equals("A"))
                    a += map.get(choices[i]);
                else if (c1.equals("N"))
                    n += map.get(choices[i]);
                else if (c1.equals("C"))
                    c += map.get(choices[i]);
                else if (c1.equals("F"))
                    f += map.get(choices[i]);
                else if (c1.equals("J"))
                    j += map.get(choices[i]);
                else if (c1.equals("M"))
                    m += map.get(choices[i]);
                else if (c1.equals("R"))
                    r += map.get(choices[i]);
                else
                    t += map.get(choices[i]);
            } else if (choices[i] == 4)
                continue;
            else {
                if (c2.equals("A"))
                    a += map.get(choices[i]);
                else if (c2.equals("N"))
                    n += map.get(choices[i]);
                else if (c2.equals("C"))
                    c += map.get(choices[i]);
                else if (c2.equals("F"))
                    f += map.get(choices[i]);
                else if (c2.equals("J"))
                    j += map.get(choices[i]);
                else if (c2.equals("M"))
                    m += map.get(choices[i]);
                else if (c2.equals("R"))
                    r += map.get(choices[i]);
                else
                    t += map.get(choices[i]);
            }     
        }
        
        if (r >= t)
            result += "R";
        else
            result += "T";
        if (c >= f)
            result += "C";
        else
            result += "F";
        if (j >= m)
            result += "J";
        else
            result += "M";
        if (a >= n)
            result += "A";
        else
            result += "N";
            
        return result;
    }
}