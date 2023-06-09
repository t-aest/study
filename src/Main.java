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
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        a = a.next;
        a.next = c;
        System.out.println("a = " + a.val);
        System.out.println("a = " + a.next.val);
        System.out.println("a = " + a.next.next);
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        ListNode result = new ListNode(0);
        ListNode p = result;
        while (list1!=null && list2!=null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1!=null){
            p.next=  list1;
        }
        if (list2!=null){
            p.next=  list2;
        }
        return result.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        if (list1.val < list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list2.next,list1);
            return list2;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode current = head;
        while (null != current.next){
            if (current.next.val == current.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicatesDiGui(ListNode head) {
        if (null == head || null == head.next){
            return head;
        }
        head.next = deleteDuplicatesDiGui(head.next);
        if (head.val == head.next.val){
            head = head.next;
            return head;
        }else {
            return head;
        }

    }

    /**
     * 环形链表  给你一个链表的头节点 head ，判断链表中是否有环。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null!=fast.next.next){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 环形链表 II 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
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
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)  return null;
        ListNode pa = headA,pb = headB;
        while (pa!=pb){
            pa = pa.next == null ? headB : pa.next;
            pb = pb.next == null ? headA : pb.next;
        }
        return pa;
    }


    /**
     * 翻转链表 单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}