package com.J;

import java.util.ArrayList;
import java.util.List;

public class CoolFeature {

    // a = [1, 2, 3]
    // b = [3, 4]
    // query = [[1, 5], [0, 0, 1], [1, 5]]

    static int[] coolFeature(int[] a, int[] b, int[][] query) {

        List<Integer> outputList = new ArrayList<>();

        for(int i = 0; i < query.length; i++) {
            if (query[i][0] == 1) {
                outputList.add(geMatchingPairCount(a, b, query[i][1]));
            } else {
                int replacingIndex = query[i][1];
                int replacingValue = query[i][2];
                b[replacingIndex] = replacingValue;
            }
        }
        int[] returnVal = outputList.stream().mapToInt(i->i).toArray();
        return returnVal;
    }

    private static int geMatchingPairCount(int[] a, int[] b, int exepectedSum) {
        int pairCount = 0;
        for (int aValue : a) {
            for (int bvalue : b) {
                if (aValue + bvalue == exepectedSum) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {3, 4};
        int[][] query = {{1, 5}, {0, 0, 1}, {1, 5}};
        int[] result = coolFeature(a, b, query);
        System.out.println(result[0] + " " + result[1]);

        int[] c = {1, 2, 2};
        int[] d =  {2, 3};
        int[][]  query1 =  {{1,4}, {0,0,3}, {1,5}};
        result = coolFeature(c, d, query1);
        System.out.println(result[0] + " " + result[1]);

        int[] e = {1, 1};
        int[] f =  {3, 3, 3};
        int[][]  query2 =  {{0, 1, 1}, {1,0}, {1,2}, {1,1}};
        result = coolFeature(e, f, query2);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);

        int[] g = {5, 6, 4, 4, 10, 6};
        int[] h =  {8, 3, 0};
        int[][]  query3 =  {{1, 12}, {1, 2}, {1, 4}, {1, 1}, {1, 12}};
        result = coolFeature(g, h, query3);
        System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4]);

        int[] i = {4, 2, 8, 1, 5, 2, 7};
        int[] j =  {2, 6, 6, 10, 1, 6};
        int[][]  query4 =  {{0, 2, 1}, {1, 3}, {0, 2, 10}, {1, 7}, {0, 1, 10}, {0, 3, 8}, {1, 3}, {0, 2, 2}, {0, 5, 8}};
        result = coolFeature(i, j, query4);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);

        int[] k = {2, 16, 10, 1, 20, 0, 9, 8, 7, 2};
        int[] l =  {1, 1, 17, 1, 19, 19, 13, 9, 0, 16};
        int[][]  query5 =  {{0,3,11}, {1,12},  {1,0}, {1,16}, {1,0}, {1,19}, {0,8,2}, {1,13}, {1,9},  {1,2}, {0,4,1},
                {1,7}, {0,0,9}, {1,32}, {0,4,16}, {1,0}, {1,27}, {0,1,7}, {1,2}, {1,20}};
        result = coolFeature(k, l, query5);
        for(int returnVal : result) {
            System.out.print(returnVal + " ");
        }
        System.out.println();

        int[] m = {8, 3, 9, 0, 3, 5, 10, 11, 9, 2};
        int[] n =  {16, 18, 16, 20, 6, 15, 7, 10, 1, 13};
        int[][]  query6 =  {{0,6,11}, {0,1,11}, {1,3}, {0,1,18}, {0,6,4}, {0,8,3}, {1,9}, {0,3,18}, {0,9,17}, {0,4,4},
                {0,9,9},  {1,8}, {1,5}, {1,0}, {1,14}, {1,26}, {0,9,13}, {1,6}, {0,6,1}, {0,3,5}};
        result = coolFeature(m, n, query6);
        for(int returnVal : result) {
            System.out.print(returnVal + " ");
        }
        System.out.println();

        int[] o = {2, 2, 7, 14, 16, 6, 20, 17, 12, 1, 5, 10, 7, 9, 0, 14, 3, 11, 1, 6, 12, 6, 18, 12, 17, 6, 8, 19, 20,
                13, 8, 0, 0, 19, 1, 18, 13, 0, 5, 8, 11, 5, 15, 7, 14, 7, 17, 19, 2, 19, 10, 14, 19, 5, 5, 20, 15, 6, 8, 15, 3, 4, 16, 11, 1, 7, 16, 3, 13, 6, 13, 6, 11, 5, 16, 1, 20, 17, 8, 0, 10, 11, 13, 4, 2, 7, 18, 19, 2, 6, 4, 17, 9, 17, 8, 5, 14, 18, 11};
        int[] p =  {0, 3, 1, 10, 20, 18, 10, 11, 1, 2, 13, 9, 18, 9, 3, 14, 17, 2, 10, 9, 18, 3, 13, 4, 9, 14, 16, 19,
                9, 4, 7, 5, 19, 15, 16, 18, 1, 8, 4, 17, 16, 4, 13, 14, 11, 4, 16, 11, 12, 9, 10, 11, 1, 10, 7, 4, 6, 2,
                10, 11, 2, 8, 10, 9, 4, 10, 9, 2, 15, 16, 2, 17, 16, 7, 0, 8, 18, 2, 1, 5, 11, 5, 16, 1, 9, 14, 1, 0,
                12, 1, 4, 14, 12, 0, 10, 12, 17, 10, 0, 13};
        int[][]  query7 =  {{1,0}, {1,28}, {0,74,8}, {0,53,3}, {1,0}, {1,2}, {0,93,13}, {0,44,19}, {1,4}, {1,23},
                {0,99,6}, {0,101,20}, {0,92,13}, {1,15}, {0,103,2}, {0,26,5}, {1,9}, {1,31}, {1,3}, {1,17}, {1,0},
                {0,29,19}, {0,11,9}, {0,67,8}, {1,9}, {0,13,19}, {0,32,0}, {0,15,5}, {1,5}, {1,1}, {1,2}, {0,97,8},
                {0,82,8}, {1,4}, {1,6}, {1,9}, {1,16}, {0,18,1}, {1,25}, {1,8}, {1,3}};

        result = coolFeature(o, p, query7);
        for(int returnVal : result) {
            System.out.print(returnVal + " ");
        }
        System.out.println();
    }
}
