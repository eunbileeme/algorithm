import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // Arrays.stream(nums).boxed().collect(Collectors.toList())
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));

        // array.length 실행 시, 2종류의 중복된 포켓몬만으로 구성되어 있을 경우
        // 최대로 고를 수 있는 폰켓몬 종류의 수에 중복된 포켓몬 개수가 포함되어 계산
        // 따라서, array와 set의 크기 중 중복된 값을 제외한 더 작은 값을 골라야 함
        return Math.min(nums.length / 2, set.size());
    }
}