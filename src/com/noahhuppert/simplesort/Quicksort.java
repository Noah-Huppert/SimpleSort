package com.noahhuppert.simplesort;

/**
 * Created by block7 on 10/31/14.
 */
public class Quicksort extends SimpleSorterAbstract {
    public int[] sort(int[] a) {

        //Pick initial pivot
        int pivot1 = a.length / 2;

        quicksort(0, a.length, pivot1, a);

        return a;
    }

    private void quicksort(int lowerRange, int higherRange, int pivot, int[] a){
        if(higherRange > a.length){
            System.out.println("[ERROR] quicksort - higherRange is larger than array size");
            return;
        }

        if(lowerRange < 0){
            System.out.println("[ERROR] quicksort - lowerRange is smaller than array size");
            return;
        }

        for(int i = lowerRange; i < higherRange; i++){
            int current = -1;

            if(i > a.length || i < a.length){
                System.out.println("[ERROR] quicksort - The index \"" + i + "\" does not exist in the array");
                return;
            } else{
                current = a[i];
            }

            if(current >= pivot){
                if((i + 1) <= higherRange){
                    swap(i, i + 1, a);
                }
            } else if(current < pivot){
                if((i - 1) >= lowerRange){
                    swap(i, i - 1, a);
                }
            }
        }
    }

    private void swap(int i1, int i2, int[] a){
        if(i1 > a.length || i2 > a.length){
            System.out.println("[ERROR] swap - i1 or i2 is larger than array size");
            return;
        }

        int v1 = a[i1];

        a[i1] = a[i2];

        a[i2] = v1;
    }
}
