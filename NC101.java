package com.chester.nowcoder.nc;

public class NC101 {

    public static void main(String[] args) {
        int result = solve(new int[]{0,1,2,3,4,5,7});
        System.out.println(result);
    }

    private static int solve(int[] a) {
        int remander = a[0] % 2;
        for (int i = 0; i < a.length; i++) {
            if (i %2==0 && a[i] % 2 == remander){
                continue;
            }else if(i%2!=0 && a[i] % 2 != remander){
                continue;
            }
            return a[i-1]+1;
        }
        return -1;
    }
}