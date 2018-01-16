package com.company.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

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


    static LinkedList<Integer>[] adjList;
    static   int nodes,edges;

    static void  addEdge(int to , int from){
        adjList[to].add(from);
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
                addEdge(Integer.parseInt(inp.split(" ")[0]), Integer.parseInt(inp.split(" ")[1]));
                edges--;
            }

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



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
