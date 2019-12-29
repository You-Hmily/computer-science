package org.hmily.datastructure.tree;


/**
 * 二叉树
 * @param <T>
 */
public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> insert(Object o){
        BinaryTreeNode<T>  newNode = new BinaryTreeNode<T>((T) o);
        if (left == null&& right == null){
            return newNode;
        }
        int newHashCode = o.hashCode();
        if (data.hashCode()> newHashCode){
            insertLeftTree(left,newNode,newHashCode);
        }else {
            insertRightTree(right,newNode,newHashCode);
        }
        return this;
    }

    private BinaryTreeNode<T> insertLeftTree(BinaryTreeNode<T> leftNode,BinaryTreeNode<T> newNode,int newHashCode){
        if (leftNode==null){
            leftNode = newNode;
            return leftNode;
        }
        if (leftNode.data.hashCode()>newHashCode){
            return insertLeftTree(leftNode.left,newNode,newHashCode);
        }else {
            return insertRightTree(leftNode.right,newNode,newHashCode);
        }
    }


    private BinaryTreeNode<T> insertRightTree(BinaryTreeNode<T> rightNode,BinaryTreeNode<T> newNode,int newHashCode){
        if (rightNode==null){
            rightNode = newNode;
            return rightNode;
        }
        if (rightNode.data.hashCode()>newHashCode){
            return insertLeftTree(rightNode.getLeft(),newNode,newHashCode);
        }else {
            return insertRightTree(rightNode.getRight(),newNode,newHashCode);
        }
    }

}
