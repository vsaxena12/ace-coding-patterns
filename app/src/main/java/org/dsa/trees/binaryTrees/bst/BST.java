package org.dsa.trees.binaryTrees.bst;

import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
    }

}

public class BST {

    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        } else if(val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public TreeNode findMin(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public TreeNode delete(TreeNode root, int val) {
        if(root == null)
            return null;
        if(val > root.val) {
            root.right = delete(root.right, val);
        } else if(val < root.val) {
            root.left = delete(root.left, val);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = delete(root.right, minNode.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = null;
        root = bst.insert(root, 4);
        root = bst.insert(root, 3);
        root = bst.insert(root, 2);
        root = bst.insert(root, 6);
        root = bst.insert(root, 5);
        root = bst.insert(root, 7);

        bst.preOrder(root);
        bst.delete(root, 3);
        bst.preOrder(root);

    }
}
