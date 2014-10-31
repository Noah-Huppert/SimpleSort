package com.noahhuppert.simplesort;

/**
 * Created by block7 on 10/31/14.
 */
public class Quicksort extends SimpleSorterAbstract {
    public int[] sort(int[] a) {

        //Pick initial pivot
        int pivot1 = a.length / 2;

        quicksort(0, a.length - 1, pivot1, a);

        return a;
    }

    private void quicksort(int lowerRange, int higherRange, int pivotIndex, int[] a){
        int pivotValue = -1;

        //Check for bad inputs
        if(lowerRange < 0){
            outOfBoundsError(lowerRange, "lowerRange");
            return;
        }

        if(higherRange >= a.length){
            outOfBoundsError(higherRange, "higherRange");
            return;
        }

        if(pivotIndex < 0 || pivotIndex >= a.length){
            outOfBoundsError(pivotIndex, "pivotIndex");
            return;
        } else{
            pivotValue = a[pivotIndex];
        }

        //Loop through all indexes in range
        for(int i = lowerRange; i <= higherRange; i++){
            //Make sure we are not sorting the pivot
            if(i == pivotIndex){
                continue;
            }

            //Determine if value is low or high
            int currentValue = a[i];

            /*Accounting for edge cases
                    O = Original Position
                    P = Pivot Position
                    N = New Position
                    [] = Array bounds
                    | = Array Element

                    New index is to high
                        [ | | | | | | O P ] N
                                  solution
                        [ | | | | | | N P ]
                    New index is to low
                        N [ P O | | | | | | ]
                                  solution
                        [ P N | | | | | | ]
                    New index is pivot index
                        [ | | O P | | | | ]
                                N
                                  solution
                        [ | | N P | | | | ]

                 */

            if(currentValue > pivotValue){//Greater
                //Swap to the correct side
                int newIndex = pivotIndex + 1;

                if(newIndex >= a.length){
                    newIndex = i;
                }

                swap(i, newIndex, a);
            } else if(currentValue < pivotValue || currentValue == pivotValue){//Less or equal
                //Swap to the correct side
                int newIndex = pivotIndex - 1;

                if(newIndex < 0){
                    newIndex = i;
                }

                swap(i, newIndex, a);
            }
        }
    }

    private void outOfBoundsError(int badValue, String displayName){
        System.out.println("[ERROR] \"" + displayName +"\" having value of \"" + badValue + "\" is out of the array bounds");
    }

    private void swap(int i1, int i2, int[] a){
        if(i1 < 0 || i1 >= a.length){
            outOfBoundsError(i1, "i1");
            return;
        }

        if(i2 < 0 || i2 >= a.length){
            outOfBoundsError(i2, "i2");
            return;
        }

        int v1 = a[i1];

        a[i1] = a[i2];

        a[i2] = v1;
    }
}
