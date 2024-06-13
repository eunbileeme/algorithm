// (1) 카운팅 정렬 알고리즘
// a. 0, 1, 2의 수를 세고
// b. 0의 개수만큼 0으로 배치한 다음
// c. 그 다음 1, 그 다음 2를 해당 요소의 개수만큼 반복해서 배치
// 

class Solution {
    public void sortColors(int[] nums) {
        // 1. 0, 1, 2의 개수를 카운트하기 위한 변수
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;

        // 2. 각 원소의 빈도수 카운트
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) zeroCnt ++;
            else if (nums[i] == 1) oneCnt ++;
            else twoCnt ++;
        }

        // 3. 0, 1, 2를 정렬하기 위한 Iterator
        // 즉, 커스텀 인덱스
        int arrIterator = 0;

        // 4. 0 배치
        // 이때, 0의 개수만큼 반복
        for (int i = 0; i < zeroCnt; i ++) {
            // 0번째(Idx)에 배치
            nums[arrIterator] = 0;
            // Iterator ++
            arrIterator ++;
        }

        // 5. 1 배치
        for (int i = 0; i < oneCnt; i ++) {
            nums[arrIterator] = 1;
            arrIterator ++;
        }

        // 6. 2 배치
        for (int i = 0; i < twoCnt; i ++) {
            nums[arrIterator] = 2;
            arrIterator ++;
        }
    }
}