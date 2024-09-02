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

// 1. 루트 노드에서부터 x까지의 거리 중 x 보다 큰 노드가 없는 경우,
// 2. x를 좋은 노드라고 함

class Solution {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return cnt;
    }

    private void dfs(TreeNode node, int maxVal) {
        if (node == null) return;

        // 현재 노드의 값이 최댓값보다 크다면
        if (node.val >= maxVal) {
            // 카운트 증가
            cnt ++;
            // 최댓값 치환
            maxVal = node.val; 
        }

        dfs(node.left, maxVal);
        dfs(node.right, maxVal);
    }
}