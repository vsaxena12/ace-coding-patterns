package org.dsa._code_regular_revision._bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BST {

    public TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
        } else {
            if(root.val > val) {
                root.left = insert(root.left, val);
            } else if(root.val < val){
                root.right = insert(root.right, val);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else {
            if(root.val < val) {
                root.right = delete(root.right, val);
            } else if(root.val > val) {
                root.left = delete(root.left, val);
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = minNode(root);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }
        return root;
    }

    public TreeNode minNode(TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
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
        root = bst.insert(root, 5);
        root = bst.insert(root, 4);
        root = bst.insert(root, 6);
        root = bst.insert(root, 3);
        root = bst.insert(root, 7);
        root = bst.insert(root, 8);
        bst.preOrder(root);

        System.out.println("\n----------------------------------");
        bst.delete(root, 6);
        bst.preOrder(root);


    }
}