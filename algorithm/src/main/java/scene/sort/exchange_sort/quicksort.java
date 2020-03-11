package scene.sort.exchange_sort;

/**
 * @Author:Gpw
 * @Date:2019/9/21
 * @Description:PACKAGE_NAME
 * @Version:1.0
 **/
public class quicksort {

    public static void quicksort(int[] arr,int left,int right){
        int i,j,base;
        if(left > right)
            return;

        i = left;
        j = right;
        base = arr[i];

        while(i < j){
            while(arr[j] >= base && i < j) j--;
            if(arr[j] < base){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            while(arr[i] <= base && i < j) i++;
            if(arr[i] > base){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        quicksort(a,0,a.length-1);
        System.out.println("结果：");
        for(int m : a)
            System.out.print(m + " ");
    }
}
