package scene.sort.selection_sort;

import java.util.Arrays;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:sort.selection_sort
 * 1：从a[0]-a[N-1]中选出最小的数据，然后与a[0]交换位置
 * 2：从a[1]-a[N-1]中选出最小的数据，然后与a[1]交换位置（第1步结束后a[0]就是N个数的最小值）
 * 3：从a[2]-a[N-1]中选出最小的数据，然后与a[2]交换位置（第2步结束后a[1]就是N-1个数的最小值）
 * 以此类推，N-1次排序后，待排数据就已经按照从小到大的顺序排列了。
 * @Version:1.0
 **/
public class StraightSelectSort {

    public static void StraightSelectSort(int arr[]){
        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 32, 35, 4, 2, 5,18,70};
        StraightSelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
