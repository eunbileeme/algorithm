/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 2-1. pos : tail에서 연결된 노드의 인덱스
// 2-2. tail에서 연결된 노드의 인덱스 == pos라면, true
// Q1. tail의 다음 노드의 인덱스 == pos여야 하는데, pos는 파라미터로 주어지지 않았는데 어떻게 비교하지?
// Q2. next는?
// Q3. 테스트케이스 추가 어떻게 하지?

public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1-1. 한 번에 2칸씩 움직이는 ListNode 타입 변수 생성
        // 이때, head는 single linked-list가 아닌 head 노드 그 자체;
        ListNode fast = head;
        // 1-2. 한 번에 1칸씩 움직이는 ListNode 타입 변수 생성
        ListNode slow = head;

        // 2-1. fast와 fast의 다음 노드가 맨 마지막 노드까지 탐색
        // fast가 2칸씩 움직이니까, 현재 노드 및 그 다음 노드까지 null이 아닐 때까지인가?
        while (fast != null && fast.next != null) {
            slow = slow.next; // slow는 한 칸씩 이동
            fast = fast.next.next; // fast는 두 칸씩 이동

            // 2-2. 노드가 만나면 사이클 존재
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
