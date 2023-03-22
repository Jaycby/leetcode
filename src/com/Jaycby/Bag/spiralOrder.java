package com.Jaycby.Bag;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName spiralOrder
 * @Author cby
 * @Date 2023/2/22 15:10
 * @Version 1.0
 */
public class spiralOrder {

    public static void main(String[] args) {

        int[][] m = new int[3][4];
        int t = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = t++;
            }
        }

        List<Integer> list = spiralOrderApi(m);
        System.out.println(list);
    }

    public static List<Integer> spiralOrderApi(int[][] matrix) {

        //螺旋遍历
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        //初始值
        int count = 1;
        int target = matrix[0].length * matrix.length;

        List<Integer> res = new ArrayList<>();

        while (target >= 1){

            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
                target--;
            }
            top++;

            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
                target--;
            }
            right--;

            for (int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
                target--;
            }
            bottom--;

            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
                target--;
            }
            left++;
        }

        return res;

    }
}
