package com.company.trees;

/**
 * Created by fran on 4/10/18.
 */
public class Diagonal_traversal {


    /**
     *          1
     *        /  \
     *       2   3
     *     /  \
     *    4    5
     *     \
     *      6
     *  Pre-order  : 1 2 4 6 5 3
     *  Post-order : 6 4 5 2 3 1
     *  In-order   : 6 4 2 5 1 3
     *  level-order: 1 2 3 4 5 6
     * */


    static Node root;
    static {
        root=new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.left.left.right = new Node("6");
    }



    public static void main(String[] args) {

        //diagonal traversal : setting weight for diagonal
        preOrder(root,false,0);



    }

    static void preOrder(Node root,boolean isLeftChild,int level){
        if (root==null){
            return;
        }
        if (isLeftChild){
            root.setNodeDisplacement(++level);
        }else {
            root.setNodeDisplacement(level);
        }
        System.out.print(root.nodeName+ " > "+root.nodeDisplacement + " | ");
        preOrder(root.left,true,level);

        preOrder(root.right,false,level);
    }

}
