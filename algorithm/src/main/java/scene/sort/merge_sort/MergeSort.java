package scene.sort.merge_sort;

import java.util.Arrays;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:sort.merge_sort
 * @Version:1.0
 **/
public class MergeSort {

    public static void mergeSort(int[] arr,int L,int R){
        if(L == R)
            return;

        //取中间的数，进行拆分
        int M = (L + R) / 2;
        //左边的数不断进行拆分
        mergeSort(arr,L,M);
        //右边的数不断进行拆分
        mergeSort(arr,M+1,R);

        //合并
        merge(arr,L,M+1,R);
    }

    public static void merge(int arr[],int L,int M,int R){

        int[] leftArr = new int[M - L];
        int[] rightArr = new int[R - M + 1];
        for(int i = L;i < M;i++)
            leftArr[i - L] = arr[i];
        for(int j = M;j <= R;j++)
            rightArr[j - M] = arr[j];

        int i = 0;
        int j = 0;
        //arr的第一个元素
        int count = L;

        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                arr[count] = leftArr[i];
                i++;
                count++;
            }else{
                arr[count] = rightArr[j];
                j++;
                count++;
            }
        }

        while(i < leftArr.length){
            arr[count] = leftArr[i];
            i++;
            count++;
        }
        while(j < rightArr.length){
            arr[count] = rightArr[j];
            j++;
            count++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {19, 32, 5, 10, 32, 27, 89, 55, 42, 81};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
