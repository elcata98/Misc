package com.misc.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(2);

        BinaryTree<Integer> sample = new BinaryTree<>(root);
        sample.add(new TreeNode<>( 1));
        sample.add(new TreeNode<>( 3));
        sample.add(new TreeNode<>( 0));
        sample.add(new TreeNode<>( 7));
        sample.add(new TreeNode<>( 9));
        sample.add(new TreeNode<>( 1));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));
//        sample.add(new TreeNode<>( 3));

        System.out.println(sample);
    }

    public BinaryTree(final TreeNode<T> root) {

        if(root == null){
            throw new IllegalArgumentException("Root node cannot be null!");
        }
        this.root = root ;
    }

    public boolean add(final TreeNode<T> node) {

        if(node == null){
            return false;
        }

        Queue<TreeNode<T>> pending = new LinkedList<>();
        pending.add(root);

        final boolean[] added = {false};
        int iterations = 1;

        while(!added[0]) {

            int finalIterations = iterations;
            TreeNode<T> current = pending.remove();

            Optional<TreeNode> left = Optional.ofNullable(current.getLeft());
            left.ifPresentOrElse(
                    pending::add,
                    () -> {
                        current.setLeft(node);
                        node.setParent(current);
                        node.setDepth(Integer.toBinaryString(finalIterations).length());
                        added[0] = true;
                    }
                );

            Optional<TreeNode> right = Optional.ofNullable(current.getRight());

            right.ifPresentOrElse(
                    pending::add,
                    () -> {
                        if (!added[0]) {
                            current.setRight(node);
                            node.setParent(current);
                            node.setDepth(Integer.toBinaryString(finalIterations).length());
                            added[0] = true;
                        }
                    }
                );

            ++iterations;
        }

        return true;
    }

    public boolean remove(final TreeNode<T> node) {

//        TODO: Implement
        return node != node;
    }

    @Override
    public String toString() {

        final StringBuilder[] result = {new StringBuilder()};

        Queue<TreeNode<T>> pending = new LinkedList<>();
        pending.add(root);

        while(!pending.isEmpty()){

            TreeNode<T> current = pending.remove();
            result[0].append(current.toString());

            Optional.ofNullable(current.getLeft()).ifPresent(pending::add);
            Optional.ofNullable(current.getRight()).ifPresent(pending::add);

            Optional.ofNullable(pending.peek())
                    .ifPresent(peek ->{
                        if(current.getDepth() != peek.getDepth()){
                            result[0].append("\n");
                        }else {
                            result[0].append(", ");
                        }
                    });
        }

        return result[0].toString();
    }

    private static class TreeNode<T> {

        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        private T value;

        private int depth = -1;

        public TreeNode(final T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(final TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(final TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(final TreeNode right) {
            this.right = right;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode<?> treeNode = (TreeNode<?>) o;
            return Objects.equals(parent, treeNode.parent) &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right) &&
                    Objects.equals(value, treeNode.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(parent, left, right, value);
        }

        @Override
        public String toString() {
            return "(" + value.toString() + ")";
        }
    }
}
