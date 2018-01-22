package com.company.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sachin on 29/12/17.
 *
 *
 Monk once went to the graph city to learn graphs, and meets an undirected graph having
 N nodes, where each node have value
 val[i] where 1≤i≤N.
 Each node of the graph is very curious and wants to know something about the nodes which are directly connected to the current node.

 For each node, if we sort the nodes (according to their values), which are directly connected to it, in descending order (in case of equal values, sort it according to their indices in ascending order), then what will be the number of the node at
 kth position, if positions are given starting from 1.

 Note: If the values are same , then sort it

 Now Graph gave this task to Monk. Help Monk for the same.

 Input Format :

 The first line will consist of
 3 space separated integers
 N,M,k denoting the number of nodes, number of edges and value of k respectively.
 In next line, there will be N space separated integers,
 val[i] , where 1≤i≤N, denoting the value of
 ith node.
 In next M lines, each line contains
 2 integers X and Y, representing an edge between
 X and Y.

 Output Format
 Print N lines, where ith line contains the required node for the ith node. If there is no such node, print −1.
 *
 *
 * SAMPLE INPUT
 3 3 2
 2 4 3
 1 3
 1 2
 2 3

 SAMPLE OUTPUT
 3
 1
 1

 */
public class Graph_Adj_list {

    public static void main(String[] args) {

        int N,M,K;
        BufferedReader inpReader  = new BufferedReader(new InputStreamReader(System.in));
        try {
            String temp = inpReader.readLine();
            N   = Integer.parseInt(temp.split(" ")[0]);
            M   = Integer.parseInt(temp.split(" ")[0]);
            K   = Integer.parseInt(temp.split(" ")[0]);

            temp = inpReader.readLine();

            int valArray[] = new int[N];
            String[] tempArray = temp.split(" ");
            for (int i = 0; i < N; i++) {
                valArray[i] = Integer.parseInt(tempArray[i]);
            }

            ArrayList<Integer> adjList[] = new ArrayList[N+1] ;

            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
               // adjList[i].add(valArray[i-1]);
            }

            while (M>0){
                temp = inpReader.readLine();
                // 1 2
                int a = Integer.parseInt(temp.split(" ")[0]);
                int b = Integer.parseInt(temp.split(" ")[1]);

                adjList[a].add(valArray[b-1]);
                adjList[b].add(valArray[a-1]);
                System.out.println("  input "+a+"  b"+b+" List>>"+adjList[a]+" ,,, "+adjList[b]);
                //watch for input 1,2 and 2,1  edges
                M--;
            }

            for (int i=1;i<=N;i++) {
                ArrayList<Integer> altList = adjList[i];
                Collections.sort(altList,Collections.reverseOrder());
                System.out.println(altList.get(K-2));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
