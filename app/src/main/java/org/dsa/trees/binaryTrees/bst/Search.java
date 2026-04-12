package org.dsa.trees.binaryTrees.bst;

// Definiton of TreeNode in Java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Search {

    public boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (target > root.val) {
            return search(root.right, target);
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        boolean isPresent =  search.search(new TreeNode(4), 4 );
        System.out.println(isPresent);
    }
}

