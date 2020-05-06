package scene.LeetCode;

/**
 * @Author:Gpw
 * @Date:2020/3/24
 * @Description:scene.LeetCode
 *  按摩师，一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 思考：动态规划
 *   dp[i][0]表示考虑前 i个预约，第 i个预约不接的最长预约时间，dp[i][1] 表示考虑前 i 个预约，第 i 个预约接的最长预约时间。
 *   dp[i][0]=max(dp[i−1][0],dp[i−1][1]) dp[i][1]=dp[i−1][0]+nums[i]  答案即为 max(dp[n][0],dp[n][1])
 */
public class masseur {

    public static int solution(int[] nums) {

        int len = nums.length;
        if (len == 0) return 0;

        int dpn0 = 0, dpn1 = nums[0];
        for (int i = 1;i < len;i++) {
            int dp0 = Math.max(dpn0, dpn1);  // 计算 dp[i][0]
            int dp1 = dpn0 + nums[i];  // 计算 dp[i][1]

            dpn0 = dp0;  // 用 dp[i][0] 更新 dp_0
            dpn1 = dp1;  // 用 dp[i][0] 更新 dp_1
        }
        return Math.max(dpn0, dpn1);
    }

    public static void main(String[] args) {

        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(solution(nums));
    }
}
