package com.zzt.algorithm.leet_code.day_20_08_26;

/**
 * 描述：<br> 74. 搜索二维矩阵
 * 网址：https://leetcode-cn.com/problems/search-a-2d-matrix/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/26 16:30
 */
public class Solution01 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            }
            if (matrix[mid / col][mid % col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    //[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
    //3
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        System.out.println(new Solution01().searchMatrix(matrix, target));
    }

}
