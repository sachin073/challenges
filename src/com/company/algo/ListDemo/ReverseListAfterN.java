package com.company.algo.ListDemo;

import java.util.List;

/**
 * Created by sachin on 21/5/18.
 *
 * Example:
 Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 Output:   3->2->1->4->5->6->9->8->7->NULL.
 */
public class ReverseListAfterN {

    static int reverseAfter=2;

    public static void main(String[] args) {

        ListBuilder list= new ListBuilder();
        list.addNode(new ListNode("first Node"));
        list.addNode(new ListNode("2nd Node"));
        list.addNode(new ListNode("3rd Node"));
        list.addNode(new ListNode("4th Node"));
        list.addNode(new ListNode("5th Node"));
        list.addNode(new ListNode("6th Node"));
        list.addNode(new ListNode("7th Node"));
        list.addNode(new ListNode("8th Node"));

        list.printNodes(list.head);

         list.head = reverse(list.head);
        System.out.println("\n");
        list.printNodes(list.head);
    }

    static ListNode reverse(ListNode node){

        ListNode curHead  = node;
        ListNode prev = node;
        curHead = node.nxtNodePointer;
        prev.nxtNodePointer = null;
        while (curHead != null){

        ListNode next = curHead.nxtNodePointer;

        curHead.nxtNodePointer = prev;
        prev =curHead;
        curHead = next;
        }

        return prev;
    }




}
