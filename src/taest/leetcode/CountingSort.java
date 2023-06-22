package taest.leetcode;

import java.util.Arrays;

public class CountingSort {

    public static int[] sortArray(int[] nums){
        if (nums.length == 0) return nums;

        //寻找数组中最大值、最小值
        int bias, min = nums[0],max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max)
                max = nums[i];
            if (nums[i]<min){
                min = nums[i];
            }
        }
        bias = 0-min;

        int[] counterArray = new int[max - min +1];
        Arrays.fill(counterArray,0);

        //遍历原始数组，将原始数组中每个元素转换为计数数组的下标   并将计数数组下标对应的元素值大小进行累加
        for (int i = 0; i < nums.length; i++) {
            counterArray[nums[i] + bias] ++;
        }

        //访问原始数组的下标
        int index = 0;
        //访问计数数组的下标
        int i = 0;
        //访问计数数组 ，将计数数组中的元素转换后，重新写回原始数组
        while (index < nums.length){
            if (counterArray[i] != 0){
                nums[index] = i - bias;
                counterArray[i]--;
                index++;
            } else {
              i++;
            }
        }

        return nums;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5,4,5,0,3,6,2,0,2,4,3,3};
        int[] ints = sortArray(nums);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
