package org.dsa.javaDSA.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMain {
    public static void main(String[] args) {
        // One Dim-Array
        int[] array1 = new int[10];

        int[] array2 = new int[]{1,2,3,4,5};

        //Copy array2 -> array1 = array1 copied 1,2,3,4
        System.arraycopy(array2, 0, array1, 0, array2.length-1);

        for(int i: array1){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] nums = {5,4,9,2,7,44,53,23,11};
        Arrays.sort(nums, 1, 4);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);


        int index = Arrays.binarySearch(nums, 44);
        System.out.println("Index value present: "+index+"->"+nums[index]);

        nums = new int[]{5, 4, 9, 2, 7, 44, 53, 23, 11, 0, -2};
        int[] copy = Arrays.copyOf(nums, 5); //5 is the length of the new copy array
        int[] copyOfRange = Arrays.copyOfRange(nums, 3, 7); //fromIndex - toIndex

        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(copyOfRange));

        int[] a = {5,4,9,2,7};
        int[] b = {5,4,9,2,7};

        boolean isEquals = Arrays.equals(a, b);
        System.out.println(isEquals);

        List<int[]> arrayAsList = List.of(a);
        for (int[] arr : arrayAsList) {
            System.out.println(Arrays.toString(arr));
        }

        Collections.reverse(Arrays.asList(a));
        for (int[] arr : arrayAsList) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
