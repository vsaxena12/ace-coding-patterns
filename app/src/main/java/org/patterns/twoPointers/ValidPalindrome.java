package org.patterns.twoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        int p1 = 0;
        int p2 = ch.length-1;
        while(p1<p2) {
            if(!Character.isLetterOrDigit(ch[p1])) {
                p1++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch[p2])) {
                p2--;
                continue;
            }
            if(ch[p1] != ch[p2]) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}