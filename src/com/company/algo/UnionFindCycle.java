package com.company.algo;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by fran on 1/15/18.
 *
 *
 *  ## solution ##
 *  ## NOTE . printing all cycle making edges including already processed edge is NP-complete problem
 *
 *  create a graph with random edges
 *
 *  Iterate over all edges and make a set parent which contain all parent considered nodes.
 *  index 0 node's parent is value at index 0 and so on..
 *
 *  if at index 1 has value 2 then is another edge come with edge has 2 then it has cycle.
 *
 */
public class UnionFindCycle {

    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
    static String inp="";

    class Edge{
        int src;
        int dest;
    }


    int vertices,edgeCount;

    Edge[] edges ;
    UnionFindCycle(int v,int e){

        this.vertices = v;
        this.edgeCount = e;
        edges = new Edge[e];

        for (int i = 0; i < edgeCount; i++) {
            edges[i] = new Edge();
        }

    }


    public static void main(String[] args) {

         UnionFindCycle ufc = new UnionFindCycle(3,3);          //edges >>> 01 , 12 ,02

        // add edge 0-1
        ufc.edges[0].src = 0;
        ufc.edges[0].dest = 1;

        // add edge 1-2
        ufc.edges[1].src = 1;
        ufc.edges[1].dest = 2;

        // add edge 0-2
        ufc.edges[2].src = 0;
        ufc.edges[2].dest = 2;

        System.out.println( ufc.containCycle(ufc));

    }

    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    boolean containCycle(UnionFindCycle graph){


        int[] parent = new int[this.vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i]=-1;
        }

        for (int i = 0; i < graph.edgeCount; ++i)
        {
            int x = graph.find(parent, graph.edges[i].src);
            int y = graph.find(parent, graph.edges[i].dest);
            System.out.println(Arrays.toString(parent));
            if (x == y)
                return true;

            graph.Union(parent, x, y);
        }

        return false;

    }



}
