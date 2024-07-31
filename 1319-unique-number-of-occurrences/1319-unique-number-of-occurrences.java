class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // 1. 원소 - 등장 횟수 저장할 Map 선언
        Map<Integer, Integer> map = new HashMap<>();

        // 2. arr 순회
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 3. map을 순회하면서, Set에 삽입
        Set<Integer> set = new HashSet<>();

        for (Integer val : map.values()) {
            set.add(val);
        }

        // 4. 만약, set의 크기와 map의 크기가 다르다면 고유하지 않음
        if (set.size() != map.size()) return false;

        return true;
    }
}