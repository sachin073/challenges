package com.company.algo.ListDemo;

/**
 * Created by fran on 2/23/18.
 Node
  > pointer to next node
  > object to store data


 */



public class ListNode {

    private ListNode nxtNodePointer;
    private String   nodeData;

    ListNode( String data){
        this.nxtNodePointer= null;
        this.nodeData=data;
    }

    public ListNode getnxtNodePointer() {
        return nxtNodePointer;
    }

    public boolean setnxtNodePointer(ListNode node) {
        try {
            this.nxtNodePointer = node;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Object getNodeData() {
        return nodeData;
    }

    public void setNodeData(String nodeData) {
        this.nodeData = nodeData;
    }

    public boolean hasNxtNode(){
        return getnxtNodePointer() != null ;
    }


}
