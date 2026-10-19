package org.dsa._code_regular_revision._bst_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
            return new TreeNode(val);
        } else if(root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if(root.val < val) {
            root.right = delete(root.right, val);
        } else if(root.val > val) {
            root.left = delete(root.left, val);
        } else {
            if(root.right == null) {
                return root.left;
            } else if(root.left == null) {
                return root.right;
            } else {
                TreeNode temp = minNode(root.right);
                root.val = temp.val;
                root.right = delete(root.right, val);
            }
        }
        return root;
    }

    private TreeNode minNode(TreeNode root) {
        TreeNode temp = root;
        while(temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = null;

        BST bst = new BST();
        root = bst.insert(root, 1);
        root = bst.insert(root, 2);
        root = bst.insert(root, 3);
        root = bst.insert(root, 4);
        root = bst.insert(root, 5);
        root = bst.insert(root, 6);
        root = bst.insert(root, 7);

        //bst.preOrder(root);

        System.out.printf(bst.inorderTraversal(root).toString());
    }
}
