package com.company.iProblems;

import java.util.*;

/**
 * Created by fran on 4/2/18.
 */
public class MapSorting {



    static     Map<Integer,String> tree;

    public static void main(String[] args) {

        tree = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        tree.put(1,"aaa");
        tree.put(3,"bbb");
        tree.put(2,"CCC");

        System.out.println(tree);

    }
}
