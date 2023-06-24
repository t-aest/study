package taest.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * 首先找出数组中最大的数  获得最大的位数  从0-10分10个桶 每个桶与位数对应  依次从个位开始  将数组中的数剧放入桶中
 * 个位排序完，将桶中数据放入数组中，开始排序十位  依次类推
 */
public class RadixSort {

    public static int[] sortArray(int[] nums){
        if (nums == null || nums.length < 2){
            return nums;
        }
        int max = nums[0];
        for (int num : nums) {
            if (max < num){
                max = num;
            }
        }
        int maxDigit = 0;
        while (max!=0){
            max /= 10;
            maxDigit ++;
        }
        int mod = 10,div = 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        //每一轮排序抖基于上轮排序后的结果
        for (int i = 0; i < maxDigit; mod *=10, div *= 10, i++) {
            //遍历原始数组放入桶中
            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }

            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] num2 = new int[]{4,6,5,1, 2, 3,8,9,7};
//        bubbleSort(num2);
        int[] ints = sortArray(num2);
        for (int i : ints) {
            System.out.println("i = " + i);
        }
    }

}
