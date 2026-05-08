package org.dsa.trees.binaryTrees.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val < val) {
            root.right = deleteNode(root.right, val);
        } else if(root.val > val){
            root.left = deleteNode(root.left, val);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    // Smallest value of the right sub-tree to replace the node which needs to be deleted
    public TreeNode minValueNode(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        BST bst = new BST();
        root = bst.insertIntoBST(root, 4);
        root = bst.insertIntoBST(root, 2);
        root = bst.insertIntoBST(root, 1);
        root = bst.insertIntoBST(root, 3);
        root = bst.insertIntoBST(root, 7);
        root = bst.insertIntoBST(root, 5);

        bst.preOrder(root);
        System.out.println("\n-----------------------------------------\n");

        bst.deleteNode(root, 4);
        bst.preOrder(root);
    }
}
