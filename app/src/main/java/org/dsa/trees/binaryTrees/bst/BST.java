package org.dsa.trees.binaryTrees.bst;

// Definition of TreeNode in Java
 class Node {
     int data;
     Node left;
     Node right;

     public Node(int value) {
         this.data = value;
         left = right = null;
     }
}

class Insertion {
     Node root;

     public Node getRoot() {
          return root;
     }

     public void setRoot(Node root) {
         this.root = root;
     }

     public void insertIterator(int value) {
         Node node = new Node(value);
         if(getRoot() == null) {
             setRoot(node);
             return;
         }
         Node temp = getRoot();
         while (temp != null) {
             if(temp.data > value) {
                 if(temp.left == null) {
                     temp.left = node;
                     return;
                 }
                 temp = temp.left;
             } else {
                 if(temp.right == null) {
                     temp.right = node;
                     return;
                 }
                 temp = temp.right;
             }
         }
     }

     public void insertRecursive(int value) {
         insertRecursiveBST(getRoot(), value);
     }

     private Node insertRecursiveBST(Node currentNode, int value) {
         if(currentNode == null) {
             currentNode = new Node(value);
             if(getRoot() == null) {
                 setRoot(currentNode);
             }
             return currentNode;
         }
         if(currentNode.data > value) {
             currentNode.left = insertRecursiveBST(currentNode.left, value);
         } else {
             currentNode.right = insertRecursiveBST(currentNode.right, value);
         }
         return currentNode;
     }


    public void preOrder(Node root) {
         if(root == null) {
             return;
         }
         System.out.print(root.data + " ");
         preOrder(root.left);
         preOrder(root.right);
     }
}

public class BST {
    public static void main(String[] args) {
        Insertion bsT = new Insertion();
        bsT.insertIterator(6);
        bsT.insertIterator(4);
        bsT.insertIterator(9);
        bsT.insertIterator(5);
        bsT.insertIterator(2);
        bsT.insertIterator(8);
        bsT.insertIterator(12);
        bsT.insertIterator(10);
        bsT.insertIterator(14);

        bsT.preOrder(bsT.getRoot());
        System.out.println();

        //Clearing the root
        bsT.setRoot(null);
        bsT.insertRecursive(6);
        bsT.insertRecursive(4);
        bsT.insertRecursive(9);
        bsT.insertRecursive(5);
        bsT.insertRecursive(2);
        bsT.insertRecursive(8);
        bsT.insertRecursive(12);
        bsT.insertRecursive(10);
        bsT.insertRecursive(14);

        bsT.preOrder(bsT.getRoot());
        System.out.println();
    }
}



//Old code
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    public TreeNode(int val) {
//        this.val = val;
//        left = null;
//        right = null;
//    }
//}
//
//
//public class InsertAndRemove {
//
//    // Insert a new node and return the root of the BST.
//    public TreeNode insert(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//
//        if (val > root.val) {
//            root.right = insert(root.right, val);
//        } else  if (val < root.val) {
//            root.left = insert(root.left, val);
//        }
//        return root;
//    }
//
//    // Return the minimum value node of the BST.
//    public TreeNode minValueNode(TreeNode root) {
//        TreeNode curr = root;
//        while(curr != null && curr.left != null) {
//            curr = curr.left;
//        }
//        return curr;
//    }
//
//    // Remove a node and return the root of the BST.
//    public TreeNode remove(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//        if (val > root.val) {
//            root.right = remove(root.right, val);
//        } else if (val < root.val) {
//            root.left = remove(root.left, val);
//        } else {
//            if (root.left == null) {
//                return root.right;
//            } else if (root.right == null) {
//                return root.left;
//            } else {
//                TreeNode minNode = minValueNode(root.right);
//                root.val = minNode.val;
//                root.right = remove(root.right, minNode.val);
//            }
//        }
//        return root;
//    }
//
//    public void preOrder(TreeNode root) {
//        if(root == null) {
//            return;
//        }
//        System.out.print(root.val+" ");
//        preOrder(root.left);
//        preOrder(root.right);
//    }
//
//    public void inOrder(TreeNode root) {
//        if(root == null) {
//            return;
//        }
//        preOrder(root.left);
//        System.out.print(root.val+" ");
//        preOrder(root.right);
//    }
//
//    public void postOrder(TreeNode root) {
//        if(root == null) {
//            return;
//        }
//        preOrder(root.left);
//        preOrder(root.right);
//        System.out.print(root.val+" ");
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        InsertAndRemove insertAndRemove = new InsertAndRemove();
//        insertAndRemove.insert(root, 3);
//        insertAndRemove.insert(root, 2);
//        insertAndRemove.insert(root, 4);
//        insertAndRemove.insert(root, 6);
//        insertAndRemove.insert(root, 5);
//        insertAndRemove.insert(root, 7);
//
//        System.out.println("\n---------------------------------------");
//        insertAndRemove.preOrder(root);
//        System.out.println("\n---------------------------------------");
//        insertAndRemove.inOrder(root);
//        System.out.println("\n---------------------------------------");
//        insertAndRemove.postOrder(root);
//
//        System.out.println();
//        insertAndRemove.remove(root, 3);
//
//        System.out.println("\n---------------------------------------");
//        insertAndRemove.preOrder(root);
//
//
//
//    }
//}
