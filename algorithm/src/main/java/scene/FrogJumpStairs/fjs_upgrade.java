package scene.FrogJumpStairs;

/**
 * @Author:Gpw
 * @Date:2019/10/14
 * @Description:scene.FrogJumpStairs
 * 青蛙跳台阶升级版
 * 一只青蛙跳台阶，一次可以跳1阶，可以2阶，其能力足够强大以至于一次可以跳n阶。那么，台阶为n时，有多少种跳法。
 *
 * 思考：
 * 假设一共有n阶，同样共有f(n)种跳法，那么这种情况就比较多，最后一步超级蛙可以从n-1阶往上跳，也可以n-2阶，也可以n-3…等等等，以此类推
 * 由分析可得
 * 1.f(n) = f(n-1) + f(n-2) + ... + f(2) + f(1)
 * 2.f(n-1) = f(n-2) + f(n-3) + ... + f(2) + f(1)
 * 则由式1,2得：f(n) = f(n-1) + f(n-1) = 2 * f(n-1)
 * @Version:1.0
 */
public class fjs_upgrade {

    public int jump(int num){
        if(num == 1)
            return 1;
        else
            return 2 * jump(num - 1);
    }
}