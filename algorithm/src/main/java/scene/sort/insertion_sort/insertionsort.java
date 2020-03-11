package scene.sort.insertion_sort;

import java.util.Arrays;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:sort.insertion_sort
 * @Version:1.0
 **/
public class insertionsort {

    public static void insertionsort(int arr[]){
        int i,j,temp;

        // 从数组的第二个元素开始循环将数组中的元素插入
        for(i = 1;i < arr.length;i++){
            // 设置数组中的第2个元素为第一次循环要插入的数据
            temp = arr[i];
            j = i-1;
            while(j >= 0 && temp < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 38,65,97,76,13,27,49 };
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
