package com.company.algo.heaping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by fran on 1/12/18.

 Binary Heap

 A Binary Heap is a Binary Tree with following properties.

 1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
        This property of Binary Heap makes them suitable to be stored in an array.

 2) A Binary Heap is either Min Heap or Max Heap.
 In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
 The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.


 inp : 3 5 9 6 8 20 10 12 18 9





 */


public class Heapper {


    static BufferedReader inpReader = new BufferedReader(new InputStreamReader(System.in));
    static String inp="";




    public static void main(String[] args) {



        boolean isMinHeap= false;

        try {

            int[] baseHeap = {3,5,9,6,8,20,10,12,18,9};

            isMinHeap=(inpReader.readLine()=="true");

            System.out.println(Arrays.toString(baseHeap));

            if (isMinHeap){
                buildMinHeap(baseHeap);
            }else{
                buildMaxHeap(baseHeap);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        // build max head


        //build min heap


    }

    static void buildMinHeap(int[] ints){



    }


    static void buildMaxHeap(int[] ints){


    }




}
