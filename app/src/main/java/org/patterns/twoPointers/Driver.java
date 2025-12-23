package org.patterns.twoPointers;

public class Driver {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean isPalindrome = validPalindrome.isPalindrome("r ace c ar");
        System.out.println("Is Palindrome: "+isPalindrome);
    }
}

