package com.chester.nowcoder.nc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 寻找第K大
 */
public class NC88 {

    public static void main(String[] args) {
        // write your code here
        int result = findKth(new int[]{10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2},12,3);
        System.out.println(result);
    }


    public static int findKth(int[] a, int n, int K) {
    Collections.sort(new ArrayList<Integer>());
        Arrays.sort(a);
        return a[n-K];
    }

}
