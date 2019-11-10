package listnode;

/**
 * 141 easy
 * 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author ilovejava1314
 * @date 2019/11/10 15:26
 */
public class LinkedListCycle {
    /**
     * 双指针法，当存在环时快慢指针始终会重合
     * 最优解
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(head==null || head.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
