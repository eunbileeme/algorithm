class Solution {
    public int solution(int n, int m, int[] section) {
        int roller = section[0]; // 롤러의 시작 위치
        int cnt = 1; // 덧칠해야 할 횟수
        for(int i = 1; i < section.length; i++) {
          // roller + m - 1 : 롤러가 닿을 수 있는 가장 먼 구간을 계산
          // ex. roller = 1(현재 구역), m = 3(롤러의 길이) --> 1 + 3 - 1 = 3번 구역
          // 즉, 1번 구역에서 롤러가 닿을 수 있는 가장 먼 구역은 3번 구역
            if(roller + m - 1 < section[i]) { // 그 범위를 벗어나는 다음 구간이 나오면
                cnt++;
                roller = section[i]; // 롤러의 시작 위치를 다음 구간으로 설정
            }
        }
        return cnt;
    }
}
