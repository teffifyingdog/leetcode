package com.wjc.lc.twentytwo.five.fifteen;

public class 最大三角形面积 {
    public static void main(String[] args) {

    }

    public static double largestTriangleArea(int[][] points) {
        double res = 0;
        int l = points.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    res = Math.max(res, 0.5 * Math.abs(triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])));
                }
            }
        }
        return res;
    }
    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
