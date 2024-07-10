/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Q. 입력값이 ListNode[]일 때, 노드 하나씩을 어떻게 확인하지? --> 입력값을 확인해야 어떻게 조작할지 알텐데, 리턴 값을 어떻게 줘야할지 모르겠어서 출력문을 못 찍어보겠네
// Q. 메서드의 반환타입이 ListNode일 때, 어떻게 반환해주지?

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. [] 또는 
        if (lists == null || lists.length == 0) return null;

        // 2. 
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. 우선순위 큐에 값을 하나씩 삽입
        for (ListNode currentNode : lists) {
            // ex. currentNode = list1([1,4,5])의 시작노드
            while (currentNode != null) {
                // ex. currentNode.val = 1
                pq.add(currentNode.val);
                // ex. currentNode.next = list1.next(즉, 4)
                currentNode = currentNode.next;
            }
        }

        // 4. [[], [1]]과 같은 예외 케이스 고려
        if (pq.size() < 1) return null;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (pq.size() > 0) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        return dummy.next;
    }
}