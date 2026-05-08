package org.dsa._code_regular_revision._bst.designHashMap;

class TreeNode {
    int key;
    int val;
    TreeNode left, right;
    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class BST {

    public TreeNode insert(TreeNode root, int key, int val) {
        if(root == null) {
            return new TreeNode(key, val);
        } else {
            if(root.key < key) {
                root.right = insert(root.right, key, val);
            } else {
                root.left = insert(root.left, key, val);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return null;
        } else {
            if(root.key < key) {
                root.right = delete(root, key);
            } else if(root.key > key) {
                root.left = delete(root, key);
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode temp = minNode(root);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
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

    public int search(TreeNode root, int key) {
        if(root == null) {
            return -1;
        } else {
            if(root.key < key) {
                search(root.right, key);
            } else if (root.key > key) {
                search(root.left, key);
            }
        }
        return root.val;
    }

    public boolean contains(TreeNode root, int key) {
        if(root == null) {
            return false;
        } else {
            if(root.key < key) {
                contains(root.right, key);
            } else if (root.key > key) {
                contains(root.left, key);
            }
        }
        return true;
    }
}

class MyHashMap {

    private final int size = 10001;
    private BST[] bst;
    private TreeNode root;

    public MyHashMap() {
        bst = new BST[size];
        for(int i=0; i<size; i++) {
            bst[i] = new BST();
        }
    }

    public void put(int key, int value) {
        int idx = key%size;
        if(!bst[idx].contains(root, key)) {
            bst[idx].insert(root, key, value);
        }
    }

    public int get(int key) {
        int idx = key%size;
        if(bst[idx].contains(root, key)) {
            return bst[idx].search(root, key);
        }
        return -1;
    }

    public void remove(int key) {
        int idx = key%size;
        if(bst[idx].contains(root, key)) {
            bst[idx].delete(root, key);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        BST bst = new BST();
        root = bst.insert(root, 1,1);
        root = bst.insert(root, 2,2);
        

        System.out.println("\n----------------------------------");
        bst.delete(root, 6);



    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */