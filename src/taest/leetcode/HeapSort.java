package taest.leetcode;

/**
 * 堆排序
 */
public class HeapSort {

    private static int len  = 0;


    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] sortArray(int[] nums){
        len = nums.length;
        if (len<1){
            return nums;
        }
        //构建一个最大堆
        buildMaxHeap(nums);

        //循环将堆首位和末尾交换，然后调整为最大堆
        while (len > 0){
            swap(nums,0,len-1);
            len--;
            adjustHeap(nums,0);
        }
        return nums;
    }

    private static void adjustHeap(int[] nums, int i) {
        int maxIndex = i;
        int left = 2*i+1;
        int right = 2*(i+1);
        //如果左子树大于根节点  交换
        if (left<len && nums[left] > nums[maxIndex]){
            maxIndex = left;
        }
        if (right<len && nums[right] > nums[maxIndex]){
            maxIndex = right;
        }
        if (maxIndex != i){
            swap(nums,maxIndex,i);
            adjustHeap(nums,maxIndex);
        }


    }


    private static void buildMaxHeap(int[] nums) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = len/2-1; i >=0; i--) {
            adjustHeap(nums,i);
        }
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
