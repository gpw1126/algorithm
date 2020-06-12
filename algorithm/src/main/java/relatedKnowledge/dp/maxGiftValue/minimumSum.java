package relatedKnowledge.dp.maxGiftValue;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:scene
 * 寻找一条从左上角（arr[0][0]）到右下角（arr[m-1][n-1]）的路线，使得沿途经过的数组中的整数和最小
 * @Version:1.0
 **/
public class minimumSum {
    /**
     * 思考：
     * 可以从右下角开始倒着分析：最后一步到达 arr[m-1][n-1]只有两条路，即通过 arr[m-2][n-1]或 arr[m-1][n-2]，假设从 arr[0][0]到
     * arr[m-2][n-1]沿途数组最小值为f(m-2,n-1),到 arr[m-1][n-2]沿途数组最小值为f(m-1,n-2)。因此，最后一步选择的路线为
     * min{f(m-2,n-1),f(m-1,n-2)}。同理到其他路径可以采用同样方式确定。
     *
     * 由此可推广到一般的情况。假设到 arr[i-1][j]与 arr[i][j-1]的最短路径和为 f(i-1,j)和 f(i,j-1)，那么到达 arr[i][j]的路径上所有
     * 数字和的最小值为 f(i,j)=min{f(i-1,j),f(i,j-1)} + arr[i][j]。
     *
     * 方法一：递归法。根据以上递归式逆向求解。
     *        效率太低，存在大量重复计算过程，如计算 f(i-1,j)和 f(i,j-1)过程总都会去计算 f(i-1,j-1)
     * 方法二：动态规划。正向求解
     *        显然，f(i,0)=arr[0][0]+......+arr[i][0],f(0,j)=arr[0][0]+......+arr[0][j]。根据递推公式 f(i,j)=min{f(i-1,j),
     *        f(i,j-1)} + arr[i][j]，从 i=1，j=1开始顺序遍历二维数组，求出所有 f(i,j)的值，同时保存到另一个二维数组中以供后续使用。
     *        当然同时可确定这个最小值对应的路线，并打印。
     */
    public static int getMinPath(int[][] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int row = arr.length;
        int col = arr[0].length;

        //为了方便看结果，打印次数到达一定值换行打印
        int count = 0;

        //cache[][]用来保存计算的中间值
        int[][] cache = new int[row][col];
        cache[0][0] = arr[0][0];
        for(int i = 1;i < col;i++)
            cache[0][i] = cache[0][i-1] + arr[0][i];
        for(int j = 1;j < row;j++)
            cache[j][0] = cache[j-1][0] + arr[j][0];

        //在遍历二维数组的过程中不断把计算结果保存到cache中
        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++){
                //确定选择的路线为arr[i-1][j]
                if(cache[i-1][j] < cache[i][j-1]){
                    cache[i][j] = cache[i-1][j] + arr[i][j];
                    System.out.print("cache[" + (i-1) + "," + j + "] ");
                    count++;
                }else{
                    //确定选择的路线为arr[i][j-1]
                    cache[i][j] = cache[i][j-1] + arr[i][j];
                    System.out.print("cache[" + i + "," + (j-1) + "] ");
                    count++;
                }
                if(count % 6 == 0)
                    System.out.println();
            }
        }
        System.out.println("cache[" + (row-1) + "," + (col-1) + "]");
        return cache[row-1][col-1];
    }

    public static void main(String[] args) {
        //int arr[][] = {{1,4,3,7,5},{8,7,5,3,2},{2,1,5,6,9},{8,1,3,9,2},{9,6,7,1,4}};
        int[][] arr = {{1,4,3},{8,7,5},{2,1,5}};
        System.out.println("路径：");
        System.out.println("\n最小值为：" + getMinPath(arr));
    }
}
