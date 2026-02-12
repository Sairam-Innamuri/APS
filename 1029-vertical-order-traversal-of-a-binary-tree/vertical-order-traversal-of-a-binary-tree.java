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
import java.util.*;
class Solution {
    static class NodeInfo {
        int row, col, val;
        NodeInfo(int r, int c, int v) {
            row = r; col = c; val = v;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (NodeInfo n : nodes) {
            if (n.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = n.col;
            }
            result.get(result.size() - 1).add(n.val);
        }
        return result;
    }
    private void dfs(TreeNode node, int row, int col, List<NodeInfo> nodes) {
        if (node == null) return;
        nodes.add(new NodeInfo(row, col, node.val));
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
