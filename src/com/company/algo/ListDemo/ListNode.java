package com.company.algo.ListDemo;

/**
 * Created by fran on 2/23/18.
 Node
  > pointer to next node
  > object to store data


 */



public class ListNode implements Comparable{

    public ListNode nxtNodePointer;
    public String   nodeData;

    ListNode( String data){
        this.nxtNodePointer= null;
        this.nodeData=data;
    }

    public ListNode getnxtNodePointer() {
        return nxtNodePointer;
    }

    @Override
    public int compareTo(Object o) {
        return this.nodeData.compareTo(((ListNode)o).nodeData);
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

    @Override
    public boolean equals(Object obj) {
        return this.nodeData.equals(((ListNode)obj).nodeData);
    }

    public String getNodeData() {
        return nodeData;
    }

    public void setNodeData(String nodeData) {
        this.nodeData = nodeData;
    }

    public boolean hasNxtNode(){
        return getnxtNodePointer() != null ;
    }


}
