package com.chester.nowcoder.level4_ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputList.add(scanner.nextLine());
        }

//        List<String> inputList = Arrays.asList();

        int ipAClassCount = 0, ipBClassCount = 0, ipCClassCount = 0, ipDClassCount = 0, ipEClassCount = 0, errorDataCount = 0, privateIpCount = 0;
        for (String item : inputList) {
            String[] itemArray = item.split("~");
            String ip = itemArray[0];
            String subnetMask = itemArray[1];
            if (checkIgnore(ip)) {
                continue;
            }
            if (!checkIp(ip) || !checkSubnetMask(subnetMask)) {
                errorDataCount++;
                continue;
            }
            if (checkPrivateIp(ip)) {
                privateIpCount++;
            }
            if (checkIpAClass(ip)) {
                ipAClassCount++;
            } else if (checkIpBClass(ip)) {
                ipBClassCount++;
            } else if (checkIpCClass(ip)) {
                ipCClassCount++;
            } else if (checkIpDClass(ip)) {
                ipDClassCount++;
//                System.out.println(item);
            } else if (checkIpEClass(ip)) {
                ipEClassCount++;
            }
        }

        System.out.println(ipAClassCount + " " + ipBClassCount + " " + ipCClassCount + " " + ipDClassCount + " " + ipEClassCount + " " + errorDataCount + " " + privateIpCount);
    }

    /**
     * A类地址1.0.0.0~126.255.255.255;
     */
    private static boolean checkIpAClass(String param) {
        if (!checkIp(param)) {
            return false;
        }
        int address0 = Integer.parseInt(param.split("\\.")[0]);
        return address0 >= 1 && address0 <= 126;
    }

    /**
     * B类地址128.0.0.0~191.255.255.255;
     */
    private static boolean checkIpBClass(String param) {
        if (!checkIp(param)) {
            return false;
        }
        int address0 = Integer.parseInt(param.split("\\.")[0]);
        return address0 >= 128 && address0 <= 191;
    }

    /**
     * C类地址192.0.0.0~223.255.255.255;
     */
    private static boolean checkIpCClass(String param) {
        if (!checkIp(param)) {
            return false;
        }
        int address0 = Integer.parseInt(param.split("\\.")[0]);
        return address0 >= 192 && address0 <= 223;
    }

    /**
     * D类地址224.0.0.0~239.255.255.255；
     */
    private static boolean checkIpDClass(String param) {
        if (!checkIp(param)) {
            return false;
        }
        int address0 = Integer.parseInt(param.split("\\.")[0]);
        return address0 >= 224 && address0 <= 239;
    }

    /**
     * E类地址240.0.0.0~255.255.255.255
     */
    private static boolean checkIpEClass(String param) {
        if (!checkIp(param)) {
            return false;
        }
        int address0 = Integer.parseInt(param.split("\\.")[0]);
        return address0 >= 240 && address0 <= 255;
    }

    /**
     * 私网IP范围是：
     * 10.0.0.0-10.255.255.255
     * 172.16.0.0-172.31.255.255
     * 192.168.0.0-192.168.255.255
     */
    private static boolean checkPrivateIp(String param) {
        if (!checkIp(param)) {
            return false;
        }
        String[] paramArray = param.split("\\.");
        int address0 = Integer.parseInt(paramArray[0]);
        int address1 = Integer.parseInt(paramArray[1]);
        return address0 == 10 || (address0 == 172 && address1 >= 16 && address1 <= 31) || (address0 == 192 && address1 == 168);
    }

    /**
     * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
     * 注意二进制下全是1或者全是0均为非法
     */
    private static boolean checkSubnetMask(String param) {
        if (!checkIp(param)) {
            return false;
        }

        boolean isMaskChar = true;
        StringBuilder subnetMaskSb = new StringBuilder();
        String[] paramArray = param.split("\\.");
        for (int i = 0; i < paramArray.length; i++) {
            StringBuilder itemSb = new StringBuilder().append(Integer.toBinaryString(Integer.parseInt(paramArray[i])));
            while (itemSb.length() < 8) {
                itemSb.insert(0,'0');
            }
            subnetMaskSb.append(itemSb);
        }
        for (int i = 0; i < subnetMaskSb.length(); i++) {
            if (i == 0 && subnetMaskSb.charAt(i) == '0') {
                return false;
            }
            if (isMaskChar && subnetMaskSb.charAt(i) == '1') {
                continue;
            }
            if (isMaskChar) {
                isMaskChar = false;
            }
            if (subnetMaskSb.charAt(i) == '1') {
                return false;
            }
        }
        if (isMaskChar) {
            return false;
        }
        return true;
    }

    /**
     * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
     */
    private static boolean checkIp(String param) {
        String[] paramArray = param.split("\\.");
        for (int i = 0; i < paramArray.length; i++) {
            String itemStr = paramArray[i];
            if (itemStr.length() == 0) {
                return false;
            }
            int item = Integer.parseInt(itemStr);
            if (item > 255 || (i == 0 && item == 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIgnore(String param) {
        String address0Str = param.split("\\.")[0];
        if (address0Str.length() == 0) {
            return false;
        }
        int address0 = Integer.parseInt(address0Str);
        if (address0 == 0 || address0 == 127) {
            return true;
        }
        return false;
    }
}
