package org.dsa._code_regular_revision._arrays_;

public class ReplaceElementWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int rightElement = -1;
        int n = arr.length;
        int[] result = new int[n];
        int max = 0;
        for(int i = n-1; i>=0; i--) {
            result[i] = rightElement;

            max = Math.max(arr[i], rightElement);
            if(max > rightElement) {
                rightElement = max;
            }
        }

        return result;
    }
}
