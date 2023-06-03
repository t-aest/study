import java.util.*;

public class Main {
    public static void main(String[] args) {
//        StringBuffer stringBuffer = new StringBuffer();
//        StringBuilder sb = new StringBuilder();
//        String a =  new String("ss");
//        //堆、方法区、 虚拟机栈、本地方法栈、程序计数器
//        LinkedHashSet linkedHashSet = new LinkedHashSet();
//        Map<String,String> map = new HashMap<>();

//        System.out.println("climbStairs(10) = " + climbStairs(10));
//        Map<Integer,Integer> cache = new HashMap();
//        System.out.println("cache = " + cache.get(0));
//        System.out.println("args = " + args);

//        int[] num1 = new int[]{4, 5, 6, 0, 0, 0};
//        int[] num2 = new int[]{1, 2, 3};
//        merge(num1, 3, num2, 3);
//        int[] num1 = new int[]{0, 5, 6, 0, 7, 0};
//        moveZeroes(num1);
//        for (int i : num1) {
//            System.out.println("i = " + i);
//        }
//        int[] num1 = new int[]{4,3,2,7,8,2,3,1};
//        findDisappearedNumbers(num1);
    }

    static Map<Integer, Integer> cache = new HashMap();


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer a = cache.get(n - 1);
        Integer b = cache.get(n - 2);
        if (a == null) {
            a = climbStairs(n - 1);
            cache.put(n - 1, a);
        }
        if (b == null) {
            b = climbStairs(n - 2);
            cache.put(n - 2, b);
        }
        return a + b;
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer index = cache.get(another);
            if (index != null) {
                result[0] = i;
                result[1] = index;
                return result;
            }
            cache.put(nums[i], i);
        }
        return result;
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int i = k - 1, num1Index = m - 1, num2Index = n - 1; i >= 0; i--) {
            if (num1Index < 0) {
                nums1[i] = nums2[num2Index--];
            } else if (num2Index < 0) {
                break;
            }else if (nums1[num1Index] > nums2[num2Index]) {
                nums1[i] = nums1[num1Index--];
            } else {
                nums1[i] = nums2[num2Index--];
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0!=nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (index >= 0 && nums[index]>=0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>(n);
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]<=n){
                result.add(i+1);
            }
        }
        return result;
    }

}