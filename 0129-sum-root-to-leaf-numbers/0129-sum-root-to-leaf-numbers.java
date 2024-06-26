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
class Solution {
    public int sumNumbers(TreeNode root) {
        // 1. sumNumbersHelper 호출
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode node, int currentSum) {
        // 2. 예외 (루트 노드가 null일 경우)
        if (node == null) return 0;

        // 3. 현재 합 계산
        currentSum = currentSum * 10 + node.val;

        // 4. 예외 (다음 왼쪽 / 오른쪽 노드가 null일 경우)
        if (node.left == null && node.right == null) return currentSum;

        // 5. 왼쪽 노드의 합 / 오른쪽 노드의 합
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);

        return leftSum + rightSum;
    }
}