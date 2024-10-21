package solution;

import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 * 示例 1:
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9]，其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 提示:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 */
public class Solution4 {

    /**
     * 计算排序后的数组中相邻元素之间的最大差值
     *
     * @param nums 给定的无序数组
     * @return 最大相邻元素差值
     */
    public int maximumGap(int[] nums) {
        int n = nums.length;

        // 如果数组长度小于2，则返回0，因为无法计算相邻元素之间的差值
        if (n < 2) {
            return 0;
        }

        // 找出数组中的最大值，用于确定最大位数
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // 使用基数排序(Radix Sort)对数组进行排序
        // `exp` 表示当前正在处理的位数（从个位开始），例如 exp = 1 表示个位
        long exp = 1;  // 指数值（从个位开始）
        int[] buf = new int[n];  // 临时数组用于保存排序结果

        // 当最大值的位数未被处理完时，继续排序
        while (maxVal > exp) {
            // `cnt` 用于计数各个数字在当前位数上出现的次数（从0到9）
            int[] cnt = new int[10];

            // 统计当前位（exp位）的数字出现次数
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;  // 提取当前位的数字
                cnt[digit]++;  // 计数该位数字出现的次数
            }

            // 将计数数组转换为位置数组，表示该数字应存放的最终位置
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            // 根据计数数组，反向遍历原数组，将其按照当前位的大小进行排序
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;  // 提取当前位的数字
                buf[cnt[digit] - 1] = nums[i];  // 将该元素放置在合适的位置
                cnt[digit]--;  // 更新计数
            }

            // 将临时数组 `buf` 中的结果复制回原数组 `nums`
            System.arraycopy(buf, 0, nums, 0, n);

            // 将指数值提升至下一位（例如从个位提升到十位）
            exp *= 10;
        }

        // 计算排序后相邻元素之间的最大差值
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);  // 更新最大差值
        }

        return ret;  // 返回最大相邻元素差值
    }
}