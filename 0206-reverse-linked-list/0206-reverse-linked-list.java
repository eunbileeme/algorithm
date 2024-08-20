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
class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. 예외
        if (head == null || head.next == null) return head;

        // 2. 이전 노드에 접근할 포인터 (= 이전에 처리된 노드)
        ListNode prev = null;
        // 3. 현재 노드에 접근할 포인터
        ListNode cur = head;

        // 4. 현재 노드가 null이 아닐 때까지
        // 단, "현재 노드의 다음이 null이 아닐 때까지"는 필요없음
        // 다음 노드가 null이어도, 이전 및 현재 노드가 값이 있을 때까지 접근해야하기 때문
        while (cur != null) {
            // 5. 다음 노드에 접근할 임시 포인터
            ListNode tmp = cur.next;

            // 6. 현재 노드(cur)의 다음을 이전 노드(prev)로 설정
            // cur의 다음 포인터가 prev를 가리킴
            cur.next = prev;

            // 7. 이전 노드(prev)를 현재 노드(cur)로 설정
            // = prev가 cur이 가리키던 노드를 가리킴
            prev = cur;

            // 8. 현재 노드(cur)를 다음 노드(tmp)로 설정
            // = cur이 tmp가 가리키던 노드를 가리킴
            cur = tmp;
        }

        return prev;
    }
}