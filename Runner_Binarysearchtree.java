/*
 * Binary Search Tree (BST) implementation in Java
 * This code defines a simple binary search tree with methods to insert and search for values.
 * It also includes a Node class to represent each node in the tree.
 * The main method demonstrates how to use the BST class.
 * Basic Operations
    Construct an empty BST
    Determine if BST is empty
    Search BST for given item
    Insert a new item in the BST
    Delete an item from the BST
    Traverse the BST
        Inorder traversal (left, root, right)
        Preorder traversal (root, left, right)
        Postorder traversal (left, right, root)
 */



class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node node = new Node(data);
            Node current = root;
            while (current != null) {
                if (node.data < current.data) {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }

        }
    }
    
    public Boolean isEmpty(BST bst) {
        return bst.root == null;
    }

    public Boolean search(int data, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return search(data, root.left);
        } else {
            return search(data, root.right);
        }

    }
    
    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
    
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                int minValue = findMin(root.right);
                root.data = minValue;
                root.right = delete(root.right, minValue);
            }
        }
    
        return root;
    }
    
    // Helper function to find minimum value in a subtree (used for deletion)
    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void Inorder(Node node) {
        if (node != null) {
            Inorder(node.left);
            System.out.print(node.data + " ");
            Inorder(node.right);
        }
    }

    public void Postorder(Node root) {
        if (root == null) {
            return;
        } 
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
        
    }

    public void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }
        
}


public class Runner_Binarysearchtree {
        public static void main(String[] args) {
            BST tree = new BST();
            tree.insert(50);
            tree.insert(30);
            tree.insert(70);
            tree.insert(20);
            tree.insert(40);
            tree.insert(60);
            tree.insert(80);
    
            tree.delete(tree.root, 70);
            
            tree.Preorder(tree.root);
            System.out.println();
            tree.Inorder(tree.root);
            System.out.println();
            tree.Postorder(tree.root);
    
            
        }
    }

