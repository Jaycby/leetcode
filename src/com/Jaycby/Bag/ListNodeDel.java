package com.Jaycby.Bag;

/**
 * @ClassName ListNode
 * @Author cby
 * @Date 2023/2/23 19:44
 * @Version 1.0
 */
public class ListNodeDel {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode node = removeElements(listNode, 6);
        System.out.println(node);
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode p = new ListNode();
        ListNode res = p;

        while (head != null) {
            if (head.val != val){
                ListNode temp = new ListNode(head.val);
                p.next = temp;
                p = p.next;
            }
            head = head.next;
        }
        return res.next;
    }


}

class ListNode{
    int val;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}