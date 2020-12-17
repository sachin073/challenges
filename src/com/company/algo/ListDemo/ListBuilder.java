package com.company.algo.ListDemo;

/**
 * Created by fran on 2/23/18.
 create linked list of size @Size


 */
public class ListBuilder {

    static int length=0;
    ListNode head;
    ListNode addPoint;

    public ListBuilder(){
        this.head=null;
        this.addPoint=null;
    }



    static ListNode getNewList(){
        ListNode listNode= new ListNode("first Node");

        ListBuilder builder= new ListBuilder();

        return builder.head;
    }


    boolean addNode(ListNode node){
        if (head == null){
            head=node;
            addPoint=head;
        }else {
            addPoint.setnxtNodePointer(node);
            addPoint= addPoint.getnxtNodePointer();
        }
        length++;
        return true;
    }

    boolean addNodeAt(ListNode node ,int position){
        ListNode tempHead = head;
        if (position-1 == 0){
            node.setnxtNodePointer(head);
            head=node;
        }else {
            int count = 0;
            while (tempHead.hasNxtNode() && count < position-1) {
                count++;
                tempHead = tempHead.getnxtNodePointer();
            }
            node.setnxtNodePointer(tempHead.getnxtNodePointer());
            tempHead.setnxtNodePointer(node);
        }
        length++;
        return true;
    }

    boolean removeNodeAt(int position){
            position--;
        if (position == 0){
            ListNode tempHead = head;
            head=head.getnxtNodePointer();
            tempHead=null;
        }else {
            ListNode prev = head;
            ListNode current = head.getnxtNodePointer();
            int count = 1;
            while (current.hasNxtNode() && count <=position){
                count++;
                current = current=current.getnxtNodePointer();
                prev = prev.getnxtNodePointer();
            }
            prev.setnxtNodePointer(current.getnxtNodePointer());
            current.setnxtNodePointer(null);
        }
        length--;
        return true;
    }


    @Override
    public String toString() {
        ListNode temp = head;
        int count =0;
        while (temp!=null){
            System.out.println(temp.getNodeData());
            count++;
            temp=temp.getnxtNodePointer();
            if(count>10){
                break;
            }

        }
        return "";
    }

    public void testList(){

        ListBuilder list = new ListBuilder();

        list.addNode(new ListNode("first Node"));
        list.addNode(new ListNode("2nd Node"));
        list.addNode(new ListNode("3rd Node"));
        list.addNode(new ListNode("4th Node"));
        System.out.println(list);
        list.addNode(new ListNode("5rd Node"));
        list.addNode(new ListNode("6th Node"));
        System.out.println(list);
        list.addNodeAt(new ListNode("new 1st Node"),1);
        list.addNodeAt(new ListNode("new 2st Node"),1);
        list.addNodeAt(new ListNode("new 3st Node"),1);
        System.out.println(list);
        list.removeNodeAt(1);
        list.removeNodeAt(4);
        System.out.println(list);

    }


    public static void main(String[] args) {
        ListBuilder list = new ListBuilder();

        list.addNode(new ListNode("first Node"));
        list.addNode(new ListNode("2nd Node"));
        list.addNode(new ListNode("3rd Node"));
        list.addNode(new ListNode("4th Node"));
        System.out.println(list);
        list.addNode(new ListNode("5rd Node"));
        list.addNode(new ListNode("6th Node"));
        System.out.println(list);
        list.addNodeAt(new ListNode("new 1st Node"),1);
        System.out.println(list);
    }


    void printNodes(ListNode node){
        while (node !=null){
            System.out.println(node.nodeData);
            node = node.nxtNodePointer;
        }
    }




}
