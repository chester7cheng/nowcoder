package com.chester.nowcoder.nc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最长递增子序列
 */
public class NC91 {

    public static void main(String[] args) {
        // write your code here
        int[] param = {2, 3, 1, 2, 3};
        int[] result = LIS(param);
        StringBuilder sb = new StringBuilder("[");

        for (int item : result) {
            sb.append(item).append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        System.out.println(sb.toString());

    }

    public static int[] LIS(int[] paramArray) {
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(paramArray[0]);
        int[] maxLengthArray = new int[paramArray.length];
        maxLengthArray[0] = 1;
        int maxIncrSubArrayLength = 0;

        for (int i = 1; i < paramArray.length; i++) {
            if (paramArray[i] > tmpList.get(tmpList.size() - 1)) {
                tmpList.add(paramArray[i]);
                maxLengthArray[i] = maxLengthArray[i - 1] + 1;
                maxIncrSubArrayLength = Math.max(maxIncrSubArrayLength, maxLengthArray[i]);
                continue;
            }
            for (int ii = 0; ii < tmpList.size(); ii++) {
                if (tmpList.get(ii) >= paramArray[i]) {
                    tmpList.set(ii, paramArray[i]);
                    maxLengthArray[i] = ii + 1;
                    maxIncrSubArrayLength = Math.max(maxIncrSubArrayLength, maxLengthArray[i]);
                    break;
                }
            }

        }

        int[] resultArray = new int[maxIncrSubArrayLength];
        for (int i = paramArray.length - 1; maxIncrSubArrayLength >= 1; i--) {
            if (maxLengthArray[i] == maxIncrSubArrayLength) {
                resultArray[--maxIncrSubArrayLength] = paramArray[i];
            }
        }
        return resultArray;
    }
}
