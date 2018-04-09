package com.company.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by fran on 4/9/18.
 */
public class Tree_traversal {



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

        System.out.println( " pre-order traversal" );
        preOrder(root);

        System.out.println( "\n post-order traversal" );
        postOrder(root);

        System.out.println( "\n in-order traversal" );
        inOrder(root);

        System.out.println( "\n level-order traversal " );
        levelOrderTraversal(root);
    }



     static void preOrder(Node root){
        if (root==null){
            return;
        }
         System.out.print(root.nodeName+ " > ");
         preOrder(root.left);

        preOrder(root.right);
    }



    static void postOrder(Node root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.nodeName+ " > ");
    }



    static void inOrder(Node root){
        if (root==null){
            return;
        }
        inOrder(root.left);

        System.out.print(root.nodeName+ " > ");

        inOrder(root.right);
    }


    static void levelOrderTraversal(Node root){
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        queue.add(new Node("separate")); // level separator
        while (queue.size()>1 ){

            Node thisNode = queue.poll();
            if (thisNode==null){
                continue;
            }
            if ("separate".equals(thisNode.nodeName)){
                queue.add(new Node("separate")); // level separator
                System.out.print(" ||new level || ");
                continue;
            }
            System.out.print(thisNode.nodeName);
            queue.add(thisNode.left);
            queue.add(thisNode.right);



        }



    }


}
