package scene.sort.exchange_sort;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:PACKAGE_NAME
 * @Version:1.0
 **/
public class bubblesort {

    public static void bubblesort(int arr[]){
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < arr.length - i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1,4,7,5};
        bubblesort(arr);
        System.out.println("结果：");
        for(int m : arr)
            System.out.print(m + " ");
    }
}
