/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode answer;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        int placeholder = examine(root, nodes);
        return answer;
    }
    public int examine(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return 0;
        }
        int leftFound = examine(root.left, nodes);
        int rightFound = examine(root.right, nodes);
        int totalFound = leftFound + rightFound;
        if (Arrays.asList(nodes).contains(root)) {
            totalFound++;
        }
        if ((totalFound == nodes.length) && (answer == null)) {
            answer = root;
        }
        return totalFound;
    }
}