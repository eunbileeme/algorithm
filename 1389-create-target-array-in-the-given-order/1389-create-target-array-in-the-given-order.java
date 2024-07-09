// 1. target 배열이 비어있다.
// 2. 왼쪽에서 오른쪽으로 nums[i] 및 index[i]를 읽고, 인덱스 index[i]에 target 배열의 값 nums[i]를 삽입
// 3. nums와 index에서 읽을 요소가 없을 때까지 반복한다.

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        // 1. 출력용 리스트
        List<Integer> tmp = new ArrayList<>();

        // 2. nums를 순회하면서
        for (int i = 0; i < nums.length; i ++) {
            tmp.add(index[i], nums[i]);
        }

        // 3. 리스트를 배열로 변환
        int[] target = tmp.stream().mapToInt(Integer::intValue).toArray();

        return target;
    }
}