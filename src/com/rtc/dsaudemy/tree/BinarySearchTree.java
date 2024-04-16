package com.rtc.dsaudemy.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    class Node<T extends Comparable<T>>{

        T value;
        Node right;
        Node left;

        public Node(T value){
            this.value = value;
        }

    }

    public boolean insert(T value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }

        Node temp = root;

        while(true){
            if(newNode.value.compareTo(temp.value) == 0) return false;
            if(newNode.value.compareTo(temp.value) < 0){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public Node<T> rInsert(Node<T> currentNode, T value){
        if(currentNode == null) return new Node<T>(value);
        if(value.compareTo(currentNode.value) < 0) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if ( value.compareTo(currentNode.value) > 0) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(T value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }
    public boolean contains(T value){
        Node temp = root;
        while(temp != null){
            if(temp.value.compareTo(value) == 0) return  true;
            temp = temp.value.compareTo(value) > 0 ? temp.left : temp.right;
        }
        return false;
    }

    public boolean rContains(Node<T> currentNode, T value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value.compareTo(currentNode.value) < 0){
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public <T extends Comparable<T>> void bfs(){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node remove = queue.remove();
            System.out.print(remove.value + " -> ");
            if(remove.left != null) queue.add(remove.left);
            if(remove.right != null) queue.add(remove.right);
        }
        System.out.println("\n");
    }

    public ArrayList<T> preOrderDFS(){
        ArrayList<T> results = new ArrayList<>();

        class Traverse{
            public Traverse(Node currentNode){

                results.add((T)currentNode.value);
                if(currentNode.left != null) new Traverse(currentNode.left);
                if(currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public List<T> postOrderDFS(){
        List<T> results = new ArrayList<>();
        class Traverse{
            public Traverse(Node currentNode){

                if(currentNode.left != null) new Traverse(currentNode.left);
                if(currentNode.right != null) new Traverse(currentNode.right);
                results.add((T)currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public List<T> inOrderDFS(){
        List<T> results = new ArrayList<>();
        class Traverse{
            public Traverse(Node currentNode){

                if(currentNode.left != null) new Traverse(currentNode.left);
                results.add((T)currentNode.value);
                if(currentNode.right != null) new Traverse(currentNode.right);
                
            }
        }
        new Traverse(root);
        return results;
    }

    public <T extends Comparable<T>> void dfs(){
        Stack<Node> stack = new Stack<>();
        if(root == null) return;

        stack.add(root);
        while(!stack.isEmpty()){
            Node remove = stack.pop();
            System.out.print(remove.value + " -> ");
            if(remove.left != null) stack.add(remove.left);
            if(remove.right != null) stack.add(remove.right);
        }
        System.out.println("\n");
    }

    /**
     * For Inorder, you traverse from the left subtree to the root then to the right subtree.
     * @param node
     */
    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value +" ");
        inOrder(node.right);
    }

    /**
     * For Preorder, you traverse from the root to the left subtree then to the right subtree.
     * @param node
     */
    public void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value +" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * For Post order, you traverse from the left subtree to the right subtree then to the root.
     * @param node
     */
    public void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value +" ");

    }

    public int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public T minimumValue(Node node){
        if(node.left != null){
            return (T) minimumValue(node.left);
        }
        return (T) node.value;
    }

    public Node<T> deleteNode(Node<T> currentNode, T value){

        if(currentNode == null ) return null;

        if(currentNode.value.compareTo(value) > 0){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if(currentNode.value.compareTo(value) < 0) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            } else if(currentNode.left == null) {
                currentNode = currentNode.right;
            } else if(currentNode.right == null) {
                currentNode = currentNode.left;
            } else{
                T minVal = (T) minimumValue(currentNode.right);
                currentNode.value = minVal;
                currentNode.right = deleteNode(currentNode.right, minVal);
            }
        }

        return currentNode;
    }

    public static void main(String[] args) {
        BinarySearchTree<Float> bst = new BinarySearchTree<>();
        bst.insert(23.0F);
        bst.insert(21.0F);
        bst.insert(19.0F);
        bst.insert(20.0F);
        bst.insert(25.0F);
        bst.insert(26.0F);
        bst.insert(27.0F);
        bst.insert(22.0F);
        bst.insert(24.0F);
        bst.insert(25.5F);
        bst.insert(23.5F);
        bst.insert(18.0F);
        bst.inOrder(bst.root);
        bst.deleteNode(bst.root, 19.0F);
        System.out.println();
        bst.inOrder(bst.root);
        System.out.println("\nMinimum Value " + bst.minimumValue(bst.root));
        System.out.println("=============");
        bst.preOrder(bst.root);
        System.out.println("=============");
        bst.postOrder(bst.root);
        System.out.println(bst.contains(18.2F));

        //breadth first search
        bst.bfs();

        //depth first search
        bst.dfs();

        System.out.println("In Order (a+b): " +bst.inOrderDFS());
        System.out.println("Pre Order (+ab): " + bst.preOrderDFS());
        System.out.println("Post Order (ab+): " +bst.postOrderDFS());

        System.out.println(bst.maxDepth(bst.root));

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.rInsert(3);
        bst2.rInsert(1);
        bst2.rInsert(4);
        bst2.bfs();

        bst2.deleteNode(bst2.root, 4);
        bst2.bfs();

    }
}
