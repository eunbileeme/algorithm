class Solution {
    public int minimumChairs(String s) {
        // 1. 최소 의자 수
        int minChairs = 0;
        // 2. 최소 의자 수의 변화를 기록하는 배열
        int[] temp = new int[s.length()];
        
        // 2. 
        for (int i = 0; i < s.length(); i ++) {
            // E일 경우, ++
            if (s.charAt(i) == 'E') minChairs ++;
            else minChairs --;
            
            temp[i] = minChairs;
        }
        
        // 3. 가장 큰 값 도출
        Arrays.sort(temp);
        
        return temp[temp.length - 1];
    }
}