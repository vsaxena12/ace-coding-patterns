package org.dsa.neetcode;

public class Sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        int res = 0;
        while(left<right) {
            mid = left + (right-left)/2;

            if((long) mid * mid > x) {
                right = mid - 1;
            } else if((long) mid * mid < x) {
                left = mid + 1;
                //res = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        int x = sqrt.mySqrt(8);
        System.out.println(x);
    }
}
