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

            int[] baseHeap = {3, 5, 6, 8, 9, 9, 10, 12, 18, 20,2}; // {3,5,9,6,8,20,10,12,18,9};

            isMinHeap=(inpReader.readLine()=="true");

            System.out.println(Arrays.toString(baseHeap));

            if (isMinHeap){
                buildMinHeap(baseHeap);
            }else{
                buildMaxHeap(baseHeap);
                System.out.println(Arrays.toString(baseHeap));
                sort(baseHeap,baseHeap.length);
            }

            System.out.println(Arrays.toString(baseHeap));


        } catch (IOException e) {
            e.printStackTrace();
        }

        // build max head


        //build min heap

    }

    static void buildMinHeap(int[] ints){
        int length =ints.length;

        // 3 5 9 6 8
        //  n-2/2 is last leaf node
        //  5-2/2 = 1
        for (int i = (length-2)/2; i >=0 ; --i) {
            maxify(ints,i,length);
        }



    }


    /**
     *@param arr input array
     *@param i
     * @param n size
     * */
    static void maxify(int[] arr, int i , int n){

        int leftNodeIndex = 2*i+1;
        int rightNodeIndex = 2*i+2;

        int largest = i;

        // check if left or right is max among root,left and right
        if (leftNodeIndex < n && arr[leftNodeIndex] > arr[largest] ){
            largest = leftNodeIndex;
        }

        if (rightNodeIndex < n && arr[rightNodeIndex] > arr[largest]){
            largest = rightNodeIndex;
        }

        // max found now swap root with max (index swap)

        if (largest != i)
        {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxify(arr, largest, n);
        }
    }


    static void buildMaxHeap(int[] ints){

        int length =ints.length;

        // 3 5 9 6 8
        //  n-2/2 is last leaf node
        //  5-2/2 = 1
        for (int i = (length-2)/2; i >=0 ; --i) {
            maxify(ints,i,length);
        }

    }

    static void sort(int[] ints, int size){
        //int length = ints.length; // we decide map size as all element are in map

        for (int i = size - 1 ; i >= 0 ; --i) {

            // transfer max/min element to last and dec. size by 1
            int temp = ints[0];
            ints[0]=ints[i];
            ints[i] = temp;


            // call max heap on decreased heap array
            maxify(ints,0,i);
            System.out.println(Arrays.toString(ints));
        }

    }








}
