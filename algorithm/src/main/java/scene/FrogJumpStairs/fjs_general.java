package scene.FrogJumpStairs;

/**
 * @Author:Gpw
 * @Date:2019/10/14
 * @Description:scene.FrogJumpStairs
 * 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * 思考：
 * 一次只能挑一阶或者两阶时。如果只有1阶，那么一共有1种跳法；
 * 如果有2阶，那么一共有2种跳法。如果有n阶时，最后一步青蛙只能从第n-1或者n-2这两种情况往上跳。
 * 那么，假设n阶时有f(n)种跳法，由上可知：
 * f(1) = 1
 * f(2) = 2
 * f(n) = f(n-1) + f(n-2)
 */
public class fjs_general {

    //方法一：递归 效率差
    public int jump(int num){
        if(num == 1)
            return 1;
        else if(num == 2)
            return 2;
        else
            return jump(num - 1) + jump(num - 2);
    }

    //方法二：非递归
    public int jump2(int num){
        if(num == 1)
            return 1;
        if(num == 2)
            return 2;
        int x = 1,y = 2,z;
        for (int i = 3;i <= num;i++){
            z = x + y;
            x = y;
            y = z;
        }
        return y;
    }
}