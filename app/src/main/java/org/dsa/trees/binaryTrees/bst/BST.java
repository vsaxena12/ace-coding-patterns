package org.dsa.trees.binaryTrees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int levelOrder = 0;

        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> elementList = new ArrayList<>();
            levelOrder = queue.size();
            for(int i=0; i<levelOrder; i++) {
                TreeNode curr = queue.poll();
                elementList.add(curr.val);

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            list.add(elementList);
        }
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int levelOrder = 0;

        if(root != null) {
            list.add(root.val);
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            TreeNode rightSide = null;
            levelOrder = queue.size();
            for(int i=0; i<levelOrder; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    rightSide = node;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(rightSide != null) {
                list.add(rightSide.val);
            }
        }
        return list;
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
        root = bst.insert(root, 1);
        root = bst.insert(root, 2);
        root = bst.insert(root, 3);
        root = bst.insert(root, 4);
        root = bst.insert(root, -1);
        root = bst.insert(root, -1);
        root = bst.insert(root, -1);
        root = bst.insert(root, 5);
        root = bst.insert(root, -1);
        root = bst.insert(root, -1);

        bst.preOrder(root);
        List<List<Integer>> list = bst.levelOrder(root);
        System.out.println(list);

        bst.rightSideView(root);

        bst.delete(root, 3);
        bst.preOrder(root);

    }
}
