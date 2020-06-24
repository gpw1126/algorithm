package scene;

import java.util.Random;

/**
 * @Author: Gpw
 * @Date: 2020/6/23
 * @Description: 洗牌算法。小E最近在设计一款斗地主小游戏，为了保证发到玩家手中的牌具有随机性，小E必须对现实世界中的洗牌过程进行模拟。
 *  本质是对数组元素进行随机重排。
 *  时间复杂度优化到了O（n）, 空间复杂度优化到了O（1）
 */
public class shuffle {

    /**
     * 将产生的随机数与数组最后一个元素交换，第二次与倒数第二个元素交换，依稀类推。
     * 好处是不需要用辅助数组，且循环结束后数组本身就是对原数组随机重排的结果。
     * @param nums
     * @return
     */
    public static int[] shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0 ; i--) {
            // 随机获取0到i的整数
            int j = random.nextInt(i + 1);
            // 随机数与最后一个元素交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] res = shuffle(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
