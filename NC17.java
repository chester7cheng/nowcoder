package com.chester.nowcoder.nc;

public class NC17 {

    public static void main(String[] args) {
//        "abcab",5
//        "abbba",5
        int result = getLongestPalindrome("1",5);
        System.out.println(result);
        result = getLongestPalindrome("baabccc",5);
        System.out.println(result);
    }


    public static int getLongestPalindrome(String A, int n) {
        int result = 1;
        for (int i = 0; i < A.length(); i++) {
            result = Math.max(result,checkPalindromeLength(A,i-1,i+1)+1);
            result = Math.max(result,checkPalindromeLength(A,i,i+1));
        }
        return result;
    }

    public static int checkPalindromeLength(String param, int leftIndex, int rightIndex) {
        if(leftIndex<0 || rightIndex>=param.length()){
            return 0;
        }
        if(param.charAt(leftIndex)!=param.charAt(rightIndex)){
            return 0;
        }
        return 2 + checkPalindromeLength(param, leftIndex-1,rightIndex+1);
    }
}
