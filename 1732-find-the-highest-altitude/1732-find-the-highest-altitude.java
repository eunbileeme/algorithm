// 1. 도로 여행은 다양한 고도의 n + 1개 지점으로 구성된다.
// 2. 자전거 타는 사람은 고도가 0인 지점 0에서 여행을 시작한다.
// 3. 여기서 gain[i]은 모든 gain(0 <= i < n)에 대해 i​​​​​​ 지점과 i + 1 사이의 고도의 순 gain
// 4. gain의 가장 높은 고도를 반환

// easy라 완탐해도 안 터질듯

class Solution {
    public int largestAltitude(int[] gain) {
        // 1. 고도의 값을 갱신하여 저장할 배열 생성
        // 0, 1, 2, 3, 4 -> 5개
        // 6개 (0, 1, 2, 3, 4, 5)
        int[] ans = new int[gain.length + 1];

        // 2. 고도는 0부터 시작
        ans[0] = 0;

        // 2. 
        int idx = 0;
        for (int i = 1; i < ans.length; i ++) {
            // 3. 현재 고도의 값 = 이전 고도의 값 + 현재 지점의 값
            ans[i] = ans[i - 1] + gain[idx];
            idx ++;

            System.out.println(ans[i]);
        }

        // 3. 정렬
        Arrays.sort(ans);

        return ans[ans.length - 1];
    }
}