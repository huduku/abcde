package com.abcde.utils;




public class IpUtils {


    public static void main(String[] args) {
        System.out.println(ipToLong("255.255.255.255")); // 285911232
//        System.out.println((int)(192L << 24));
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(int2Ip(285911232));
        System.out.println(long2Ip(4294967295L));

    }

    public static int ip2Int(String ip){
        String[] ipItems = ip.split("\\.");
        int ip1 = Integer.parseInt( ipItems[0] )  << 23 ;
        int ip2 = Integer.parseInt( ipItems[1]) << 16;
        int ip3 = Integer.parseInt( ipItems[2]) << 8;
        int ip4 = Integer.parseInt( ipItems[3]) ;
        int intIp = ip1 * 2 + ip2 + ip3 + ip4;
        System.out.println(intIp);
        return intIp;
    }

    public static String int2Ip(int intIp){
        return String.valueOf(intIp >> 22);
    }



    public static long ipToLong(String ip) {
        String[] ipItems = ip.split("\\.");
        long ip1 = Long.parseLong( ipItems[0] )  << 24 ;
        long ip2 = Long.parseLong( ipItems[1]) << 16;
        long ip3 = Long.parseLong( ipItems[2]) << 8;
        long ip4 = Long.parseLong( ipItems[3]) ;

        return ip1 + ip2 + ip3 + ip4;
    }

    public static String long2Ip(long longIP) {
        String[] ip = new String[4];
        ip[0] = String.valueOf(longIP >> 24);
        ip[1] = String.valueOf((longIP >> 16)  & 0x00FF);
        ip[2] = String.valueOf((longIP >> 8)  & 0x0000FF);
        ip[3] = String.valueOf((longIP )  & 0x000000FF);
        StringBuilder ipBuilder = new StringBuilder();
        return ipBuilder.append(ip[0]).append(".")
                .append(ip[1]).append(".")
                .append(ip[2]).append(".")
                .append(ip[3]).toString();
    }
}
