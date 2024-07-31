class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 1. nums1과 nums2를 담을 Set 선언
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 2. nums1과 nums2를 순회하면서 원소 삽입
        for (int i = 0; i < nums1.length; i ++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i ++) {
            set2.add(nums2[i]);
        }

        // 3. set1과 nums2 비교
        // 이때, 이중 리스트를 반환하기 위해서 1차원 리스트를 생성해야
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // 4. nums1의 원소가 nums2에 없다면
        for (Integer val : set1) {
            if (!set2.contains(val)) {
                list1.add(val);
            }
        }

        // 5. nums2의 원소가 nums1에 없다면
        for (Integer val : set2) {
            if (!set1.contains(val)) {
                list2.add(val);
            }
        }

        return Arrays.asList(list1, list2);
    }
}