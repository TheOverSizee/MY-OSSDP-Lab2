package solution;

import org.junit.Test;

public class L2022211837_4_Test {

   /*
    *测试用例设计的总体原则
    *等价类划分：根据输入数据的不同特性，将其划分为不同的等价类，每个等价类选择一个代表性的测试用例
    *边界值分析：考虑输入数据的边界值，例如数组长度为0、1、2等情况
    */

   /*
    *测试目的：验证函数在正常情况下能否正确计算相邻元素之间的最大差值
    *测试用例：{3, 6, 9, 1}
    *预期结果：3
    */
    @Test
    public void test() {
        Solution4 s = new Solution4();
        int[] nums = new int[]{3,6,9,1};
        int result = s.maximumGap(nums);
        System.out.println(result);
    }

    /*
     *测试目的：验证函数在数组长度小于2的情况下能否正确返回0
     *测试用例：{10}
     *预期结果：0
     */
    @Test
    public void test2() {
        Solution4 s = new Solution4();
        int[] nums = new int[]{10};
        int result = s.maximumGap(nums);
        System.out.println(result);
    }

}