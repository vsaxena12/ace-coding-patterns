package org.dsa.twoPointer;

public class ReverseString {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }

    private void reverse(char[] s, int left, int right) {
        if(left<right) {
            reverse(s, left+1, right-1);
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'n','e','e','t'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(chars);
        System.out.println(chars);
    }
}
