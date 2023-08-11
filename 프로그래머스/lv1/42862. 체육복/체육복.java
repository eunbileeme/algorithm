import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
 
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer ++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }
 
        // 도난당한 학생에게 체육복을 빌려주는 경우
        for (int lostPerson : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lostPerson - 1 || reserve[i] == lostPerson + 1) {
                    answer ++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}