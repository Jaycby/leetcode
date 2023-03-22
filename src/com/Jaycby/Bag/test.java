package com.Jaycby.Bag;

import java.util.*;

/**
 * @ClassName test
 * @Author cby
 * @Date 2023/3/3 19:11
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {


//        // 在堆中创建字符串对象”Java“
//        // 将字符串对象”Java“的引用保存在字符串常量池中
//         String s1 = "Java";
//        // 直接返回字符串常量池中字符串对象”Java“对应的引用
//         String s2 = s1.intern();
//        // 会在堆中在单独创建一个字符串对象
//         String s3 = new String("Java");
//        // 直接返回字符串常量池中字符串对象”Java“对应的引用
//         String s4 = s3.intern();
//        // s1 和 s2 指向的是堆中的同一个对象
//         System.out.println(s1 == s2); // true
//        // s3 和 s4 指向的是堆中不同的对象
//         System.out.println(s3 == s4); // false
//        // s1 和 s4 指向的是堆中的同一个对象
//         System.out.println(s1 == s4); //true

//        String a = new String("ab"); // a 为一个引用
//        String b = new String("ab"); // b为另一个引用,对象的内容一样
//        String aa = "ab"; // 放在常量池中
//        String bb = "ab"; // 从常量池中查找
//        System.out.println(aa == bb);// true
//        System.out.println(a == b);// false
//        System.out.println(a.equals(b));// true
//        System.out.println(42 == 42.0);// true
//
//        String sp = ap(a);
//        System.out.println(a);

//        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
////
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
////        boolean palindrome = isPalindrome(head);
////        System.out.println(palindrome);
//
////        if (head == null || head.next == null){
////            return;
////        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        //此时 slow指向链表中间位置
//        fast = slow.next;
//        //断开
//        slow.next = null;
//        // 对后半部进行反转
//        ListNode pre = null;
//        ListNode temp = null;
//        while (fast != null){
//            temp = fast.next;
//            fast.next = pre;
//            pre = fast;
//            fast = temp;
//        }
//        //此时得到了以pre为头结点的后半部分链表
//        slow = head;
//        ListNode res = new ListNode();
//        while (slow != null && pre != null){
//            res.next = slow;
//            res.next.next = pre;
//            slow = slow.next;
//            pre = pre.next;
//
//            res = res.next.next;
//        }
        String s = "ab#c";
        String t = "ad#c";
        String s1 = deal(s);
        String s2 = deal(t);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }

    public static String deal(String str){

        Deque<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : str.toCharArray()){
            if (ch != '#'){
                queue.offerLast(ch);
            }else {
                queue.pollLast();
            }
        }
        while (!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }

    public static class ListNode {
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

    public static boolean isPalindrome(ListNode head) {

        ListNode pre = null;
        ListNode cur = new ListNode();
        cur = head;
        ListNode behind = null;

        ListNode temp = head;

        //反转,得到一条以pre为头的链表
        while (cur != null) {

            behind = cur.next;

            cur.next = pre;

            pre = cur;
            cur = behind;
        }

        while (pre != null && temp != null) {
            if (pre.val != temp.val) {
                return false;
            }
            pre = pre.next;
            temp = temp.next;
        }
        return true;
    }

    public static String ap(String s) {
        s += "ccc";
        return s;
    }

    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0; // 计算原数组中所有元素的和
        for (int num : nums) {
            sum += num;
        }
        long remainder = sum % p; // 求和对p取模的余数
        if (remainder == 0) { // 如果余数为0，则整个数组可以被移除
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1); // 初始化哈希表，将前缀和为0的位置设置为-1
        long prefixSum = 0; // 初始化前缀和
        int minLen = n; // 初始化最小长度为n，即最坏情况下需要移除整个数组
        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % p; // 计算前缀和
            long target = (prefixSum - remainder + p) % p; // 计算目标值
            if (map.containsKey(target)) { // 如果哈希表中存在目标值
                int len = i - map.get(target); // 计算中间一段子数组的长度
                minLen = Math.min(minLen, len); // 更新最小长度
            }
            map.put(prefixSum, i); // 将前缀和和对应位置存入哈希表
        }
        return minLen == n ? -1 : minLen; // 如果最小长度等于n，则返回-1；否则返回最小长度
    }

    public static int minSubarray2(int[] nums, int p) {
        int x = 0;
        //所有元素的和，与目标取模
        for (int num : nums) {
            x = (x + num) % p;
        }
        //如果所有元素的和与p整除，不需要删除子数组
        if (x == 0) {
            return 0;
        }
        //哈希表 key保存每个前缀的和与p的取模值，value表示是第几个元素的前缀
        //例如：value = 1 ， 表示nums[1]之前的所有元素之和 ， 子数组的长度就是 i - 1 + 1
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // 存放 第i个元素的前缀和与p的取模值
            y = (y + nums[i]) % p; //第i个元素的前缀之和，与p取模
            // 如果第i个元素的前缀和与p的取模值 减去 所有元素之和与p的取模值 的差（+p是保持为正数，不影响操作数） % p 的值
            if (index.containsKey((y - x + p) % p)) {
                //根据 y % p = x 那么 (y - z) % p = 0 等价于 z % p = x 定理
                //(y - z) % p = x  等价于  z % p = (y - x) % p 定理
                //(y - x + p) 相当于 剩余数组的和

                //也就是说，剩余数组和%p = 某个前缀和%p ，根据定理可知
                //取出剩余数组 与 前缀数组之间的子数组，所得到的数组和就能够被p整除（注意：子数组是连续的）
                res = Math.min(res, i - index.get((y - x + p) % p) + 1); //获取最小值
            }
        }

        return res == nums.length ? -1 : res;
    }


    //1、去掉不必要的空格
    public static String remove(String s) {

        int left = 0;
        int right = s.length() - 1;

        //去掉前面的空格
        while (s.charAt(left) == ' ') {
            left++;
        }

        //去掉后面的空格
        while (s.charAt(right) == ' ') {
            right--;
        }

        //去掉中间的多余空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {

            char c = s.charAt(left);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }

        return sb.toString();
    }

    //2、将指定区间的字符串进行翻转
    public static String reverseAll(String s, int start, int end) {

        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            sb.append(s.charAt(end));
            end--;
        }
        return sb.toString();
    }

    //3、将每个单词进行翻转
    public static String reverseSingle(String s) {

        StringBuilder sb = new StringBuilder();

        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                //进行翻转
                String temp = reverseAll(s, left, i - 1);
                sb.append(temp + " ");
                left = i + 1;
            }
            if (i == s.length() - 1) {
                sb.append(reverseAll(s, left, i));
            }
        }
        return sb.toString();
    }
}


