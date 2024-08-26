/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 헤드 노드 root1과 root2가 있는 지정된 두 트리가 리프 유사인 경우에만 true를 반환합니다.

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 1. 리스트에 각 트리의 리프 노드를 저장
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // 2. 각 트리에 대한 각각의 탐색
        // ※ 매개변수 : 탐색하고자 하는 노드, 리프 노드를 저장할 리스트
        dfs(root1, list1);
        dfs(root2, list2);

        // ※ 비교할 대상1.equals(비교할 대상2)
        return list1.equals(list2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        // 3. 예외
        if (node == null) return;

        // 4. 왼쪽 자식 노드와 오른쪽 자식 노드가 null이라면 = 리프 노드 -> 리스트에 저장
        if (node.left == null && node.right == null) {
            // ※ 현재 노드의 값을 리스트에 저장
            list.add(node.val);
        }

        // 5. 왼쪽 자식 노드가 n ..
        if (node.left != null) dfs(node.left, list);
        
        // 6. 오른쪽 자식 노드가 ..
        if (node.right != null) dfs(node.right, list);
    }
}