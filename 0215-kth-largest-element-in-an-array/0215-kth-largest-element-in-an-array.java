class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 배열 -> 리스트
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // 최대 힙 정의
        // 이때, Comparator 및 Collection을 모두 받는 생성자는 없으므로, PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 이용
        PriorityQueue<Integer> maxHeap = new PriorityQueue(numList.size(), Collections.reverseOrder());

        // 리스트의 요소들을 최대 힙에 추가
        maxHeap.addAll(numList);

        // k번째 값을 꺼내기
        // 단, Priority Queue에서는 .get(E e)를 지원하지 않으므로, .remove() + .peek() 조합으로 값을 가져오기
        int size = maxHeap.size();

        // Iterator를 사용할 경우, 동시성 이슈가 발생하므로 basic for 사용
        // one-based index이므로 1부터 시작 && k번째 값을 꺼내야하므로 k번째 전까지 순회
        for (int i = 1; i < k; i ++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}