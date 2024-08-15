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

// n = 1, 2, 3, 4, 5인 경우 중간 노드는 각각 0, 1, 1, 2, 2입니다.
// 중간 노드 = [n / 2]

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // 1. 링크드 리스트의 사이즈를 구함
        if (head == null || head.next == null) {
            return null;  // 리스트가 비어있거나 노드가 하나만 있는 경우
        }

        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // 2. 중간 노드를 구함
        int middleIndex = size / 2;

        // 3. 중간 노드까지 접근해서 해당 노드를 삭제함
        current = head;
        for (int i = 0; i < middleIndex - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        // 4. 링크드 리스트를 반환
        return head;
    }
}