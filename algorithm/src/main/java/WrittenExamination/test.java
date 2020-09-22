package WrittenExamination;

import java.util.Scanner;

/**
 * @Author: Gpw
 * @Date: 2020/7/23
 * @Description:
 */
public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        print(arr);
    }
    public static void print(int[][] arr){
        int left = 0,right = arr[0].length-1,top = 0,bottom = arr.length-1;
        while(left<=right&&top<=bottom){
            for(int i=top;i<=bottom;i++) System.out.print(arr[i][left]);
            for(int j=left+1;j<=right;j++) System.out.print(arr[bottom][j]);
            if(left<right&&top<bottom){
                for(int i=bottom-1;i>=top;i--) System.out.print(arr[i][right]);
                for(int j=right-1;j>left;j--) System.out.print(arr[top][j]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
