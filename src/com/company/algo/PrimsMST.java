package com.company.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fran on 1/16/18.
 *
 * Prims algorithm is to find MST i.e to find a path to traverse all node with min. weight
 * and this path might not be  the shortest path for specific nodes.
 *
 *
 *
 *
 * inp:
 *      () node:
 *     -3-(4)-2-(6)
 *    |    |
 *   (1)   1
 *    |    |
 *     -2-(2)-10-(9)
 *
 */
public class PrimsMST {


    //static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader inpReader =null;
    static String inp="";


    static LinkedList<Edge>[] adjList;
    static   int nodes,edges;

    static void  addEdge(int to , Edge edge){
        adjList[to].add(edge);
    }

   static void printList(LinkedList<Edge>[] list){

            int i= 0;
        for (LinkedList<Edge> mst: list) {
            System.out.print(i +" >>>>>> [ ");
            Iterator<Edge> itr = mst.listIterator();
            while (itr.hasNext()){
                Edge temp = itr.next();
                System.out.print( temp  );
                if(itr.hasNext()){
                    System.out.print(",");
                }
            }
            System.out.println("] ");
            i++;
        }
    }

    static class Edge{
        int node;
        int weight;

        Edge(int node, int weight){
            this.node = node;
            this.weight = weight;
        }


        @Override
        public String toString() {
            return " ( node name: "+node+" || weight >>"+weight + ") ";
        }
    }

    static void makeGraph(){

        try {
            adjList = new LinkedList[nodes];

            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }

            //make graph

            while (edges > 0) {

                inp = inpReader.readLine();

                addEdge(Integer.parseInt(inp.split(" ")[0])  ,
                        new Edge(Integer.parseInt(inp.split(" ")[1]), Integer.parseInt(inp.split(" ")[2])) );

                addEdge(Integer.parseInt(inp.split(" ")[1]) ,
                        new Edge(Integer.parseInt(inp.split(" ")[0]), Integer.parseInt(inp.split(" ")[2])) );

                edges--;
            }

            printList(adjList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {



        try {

            inpReader =  new BufferedReader(new FileReader("src/file_input_package/input.txt"));
            //System.out.println(inpReader.readLine());
            nodes = Integer.parseInt(inpReader.readLine());
            edges = Integer.parseInt(inpReader.readLine());

            makeGraph();

            MST();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    static void MST(){

        //int mst[]= new int[nodes];

        int source =0;

        boolean[] visited = new boolean[nodes];  // weather node is traversed or not

        List<Edge> mst = new ArrayList<>();

        List<Edge> weightMst = new ArrayList<>();

        weightMst.add(new Edge(0,0));   //start from node name 0 and so weight is 0.

        for (int i = 0; i < nodes ; i++) {



            // find Min weight node in weightMst
            //List<Integer> temp = new ArrayList<>();

            Edge min= weightMst.get(0);

            for (Edge e:weightMst ) {
              //  temp.add(e.weight);
                if (min.weight > e.weight){
                    min =e;
                }
            }


            //min found  node add in mst and remove from weightMST
            mst.add(min);
            weightMst.remove(min); // can it collide>> no

            visited[min.node]=true;

            //add its neighbour nodes
            for (Edge ex :adjList[i]) {
                if (!visited[ex.node]) {
                    weightMst.add(ex);
                }
            }

        }

        System.out.println(mst);

    }

}
