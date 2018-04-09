package com.company.trees;

/**
 * Created by fran on 4/9/18.
 */
public class Node {
    Node left;
    Node right;
    String nodeName;

    Node(String name){
        nodeName = name;
    }

    Node(Node left,Node right,String nodeName){
        this.left= left;
        this.right=right;
        this.nodeName=nodeName;
    }
}
