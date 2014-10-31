package com.noahhuppert.simplesort;

import java.util.ArrayList;
import java.util.Collections;

// sorter that needs to be completed by YOU, trying to figure out how to sort an array
public class MySorter extends SimpleSorterAbstract {
	public int[] sort(int[] a) {
        ArrayList<Integer> notSorted = new ArrayList<Integer>();
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        //Add array to notSorted
        for(int n : a){
            notSorted.add(n);
        }

        /*
        Loop through notSorted
            Find greatest
                Append to sorted
                Remove from notSorted
         */

        while(notSorted.size() > 0){
            int greatest = -1;

            for(int n1 : notSorted){
                if(n1 > greatest){
                    greatest = n1;
                }
            }

            notSorted.remove(notSorted.indexOf(greatest));

            sorted.add(greatest);
        }

        int[] result = new int[sorted.size()];

        Collections.reverse(sorted);

        for(int i = 0; i < sorted.size(); i++){
            result[i] = sorted.get(i);
        }

		return result;
	}
}
