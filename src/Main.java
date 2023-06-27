import taest.thread.dto.T;

import java.util.*;

public class Main {
    public static int ptr;


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
            } else if (nums1[num1Index] > nums2[num2Index]) {
                nums1[i] = nums1[num1Index--];
            } else {
                nums1[i] = nums2[num2Index--];
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
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
            int index = Math.abs(nums[i]) - 1;
            if (index >= 0 && nums[index] >= 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
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
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        ListNode result = new ListNode(0);
        ListNode p = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return result.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list2.next, list1);
            return list2;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (null != current.next) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicatesDiGui(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        head.next = deleteDuplicatesDiGui(head.next);
        if (head.val == head.next.val) {
            head = head.next;
            return head;
        } else {
            return head;
        }

    }

    /**
     * 环形链表  给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环形链表 II 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean lookExist = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                lookExist = true;
                break;
            }
        }

        if (lookExist) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
        return null;

    }

    /**
     * 相交链表 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa.next == null ? headB : pa.next;
            pb = pb.next == null ? headA : pb.next;
        }
        return pa;
    }


    /**
     * 翻转链表 单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 回文链表  给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 链表的中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!=null&& fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;
        while (ptr < s.length()){
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)){
                String digits = getDigits(s);
                stk.addLast(digits);
            }else if (Character.isLetter(cur) || cur == '['){
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int count = Integer.parseInt(stk.removeLast());
                StringBuilder ret = new StringBuilder();
                String string = getString(sub);
                while (count-- > 0){
                    ret.append(string);
                }
                stk.addLast(ret.toString());
            }
        }
        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        return sb.toString();
    }

    public List<Integer> inorderTraversalFast(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre){
                result.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        accessTree(root,result);
        return result;
    }

    private void accessTree(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        accessTree(root.left,result);
        result.add(root.val);
        accessTree(root.right,result);
    }

    /**
     * 对称二叉树   给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        return deepcheck(root.left,root.right);
    }

    public boolean isSymmetricQueue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null){
            return true;
        }
        q.offer(left);
        q.offer(right);
        while (!q.isEmpty()){
            left = q.poll();
            right = q.poll();
            if (left == null && right == null){
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)){
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

    public boolean deepcheck(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return deepcheck(left.left,right.right) && deepcheck(left.right,right.left);
    }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 平衡二叉树  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return decisionTree(root)!=-1;
    }

    private int decisionTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = decisionTree(root.left);
        int right = decisionTree(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 冒泡排序  二二比较 i和i+1比较   每一轮找到一个最大值到末尾
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j+1] < nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序 首先找到数组中最大（小）的元素  然后和第一个元素比较交换位置，然后继续找最小的和第二个元素比较交换  以此类推
     * @param nums
     */
    public static void choiceSort(int[] nums){
        if (nums.length == 0){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.println("minIndex = " + nums[minIndex]);
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }


    /**
     * 插入排序  默认前面部分排好序，后面往前面排好序的里面插入，插入时，排好序的需要向后移动一位
     * @param nums
     */
    public static void insertionSort(int[] nums){
        if (nums.length == 0){
            return;
        }
        int current;
        for (int i = 0; i < nums.length-1; i++) {
            int preIndex = i;
            current = nums[preIndex + 1];
            while (preIndex >=0 && nums[preIndex] > current){
                nums[preIndex +1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }

    }

    /**
     * 希尔排序  按增量分组排序  例子 14个元素  分为7，3，1   组内使用插入排序
     * @param nums
     */
    public static void shellSort(int[] nums){
        int length = nums.length;
        if (nums.length == 0) {
            return;
        }
        int current, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                //待排序值
                current = nums[i];
                //已排序下标
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > current) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex = preIndex - gap;
                }
                nums[preIndex + gap] = current;
            }

            gap = gap / 2;
        }
    }

    /**
     * 归并排序  切分数组  然后递归排序   merge合并
     * @param nums
     */
    public static int[] mergeSort(int[] nums){
        if(nums.length < 2){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left),mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i>=left.length){
                result[index] = right[j++];
            } else if (j>= right.length){
                result[index] = left[i++];
            } else if (left[i] > right[j]){
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 只出现一次的数字
     * 数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


    /**
     * 比特位计数
     * @param num    21的二进制1的个数等于    (21&(21-1)) +1  依次类推
     *
     * @return
     */
    public static int[] countBits(int num) {
        int[] bits = new int[num+1];
        //bits[0]默认为0
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i&(i-1)] + 1;
        }
        return bits;

    }

    /**
     * 比特位计数
     * @param num    利用奇偶性   16.8.4中1的个数相同
     *
     * @return
     */
    public static int[] countBits1(int num) {
        int[] bits = new int[num+1];
        //bits[0]默认为0
        for (int i = 1; i <= num; i++) {
            bits[i] = (i&1) ==1 ? bits[i-1] +1 : bits[i >> 1];
        }
        return bits;

    }

    /**
     * 汉明距离   就是求两个数按位异或后的二进制中含有几个1
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = x^y; i !=0; i&=i-1) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num2 = new int[]{4,6,5,1, 2, 3,8,9,7};
//        bubbleSort(num2);
        int[] ints = mergeSort(num2);
        for (int i : ints) {
            System.out.println("i = " + i);
        }
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
//        ListNode a = new ListNode(0);
//        ListNode b = new ListNode(1);
//        ListNode c = new ListNode(2);
//        a.next = b;
//        a = a.next;
//        a.next = c;
//        System.out.println("a = " + a.val);
//        System.out.println("a = " + a.next.val);
//        System.out.println("a = " + a.next.next);

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}