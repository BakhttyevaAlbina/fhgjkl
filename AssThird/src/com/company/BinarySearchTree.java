package com.company;

public class BinarySearchTree<T extends Comparable<T>> {
    //T is the type parameter and comparable
    Node root;  //root node of the tree

    //defines each node of tree
    class Node{
        T value;  //value of node
        Node right,left;  //pointer to left and right sub-tree

        Node(T value){
            this.value = value;
        }
    }

    /**
     * This method inserts new node in tree
     * @param value
     */
    public void insert(T value){
        if(isEmpty())
            root = new Node(value);  //root node added
        else
            insert(root, value);  //if not empty then insert based on root
    }

    /**
     * Recursive method is called internally to insert nodes at proper
     places depending on their vakues.
     * @param node
     * @param value
     */
    private void insert(Node node, T value){
        if(value.compareTo(node.value) < 0){  //if new value less than parent node
            if(node.left == null)  //if left null then add
                node.left = new Node(value);
            else
                insert(node.left,value);  //if left not null then recursive call
        }
        else if(value.compareTo(node.value) >= 0){  //if new value same or greater than parent node
            if(node.right == null)  //if right null then add
                node.right = new Node(value);
            else
                insert(node.right,value);  //if right not null then recursive call
        }
    }

    /**
     * Returns the value of the root
     * @return
     */
    public T peek(){
        return root.value;
    }

    /**
     * Checks if tree is empty or not
     * @return
     */
    public boolean isEmpty(){
        return (root == null)? true : false;
    }
}