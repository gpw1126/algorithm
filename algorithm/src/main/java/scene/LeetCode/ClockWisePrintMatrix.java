package scene.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Gpw
 * @Date:2020/5/8
 * @Description: 顺时针打印矩阵（螺旋矩阵） LeetCode 54   剑指offer 29
 *  时间复杂度： O(N)，其中 N 是输入矩阵所有元素的个数
 *  空间复杂度： O(N)
 */
public class ClockWisePrintMatrix {

    /**
     * 最外层所有元素按照顺时针顺序输出，其次是次外层，以此类推。
     * @return
     */
    public List<Integer> solution(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            // 遍历矩阵上边元素
            for (int i = left;i <= right;i ++) {
                list.add(matrix[top][i]);
            }
            // 遍历矩阵右边元素
            for (int j = top + 1;j <= bottom;j ++) {
                list.add(matrix[j][right]);
            }
            // 判断是否需要继续遍历
            if (left < right && top < bottom) {
                // 遍历矩阵下边元素
                for (int i = right - 1;i > left;i --) {
                    list.add(matrix[bottom][i]);
                }
                // 遍历矩阵左边元素
                for (int j = bottom;j > top;j --) {
                    list.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ClockWisePrintMatrix clockWisePrintMatrix = new ClockWisePrintMatrix();
        System.out.println(clockWisePrintMatrix.solution(matrix));
    }
}
