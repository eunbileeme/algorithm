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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 예외
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 2. 두 리스트 병합
        // 2-1. list1 노드의 값이 list2 노드의 값보다 작다면
        if (list1.val < list2.val) {
            // 2-2. 해당 list1 노드 반환 후, 노드의 next를 list1.next 노드와 list2 노드의 값을 비교
            list1.next = mergeTwoLists(list1.next, list2);
            // 해당 노드 반환
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}