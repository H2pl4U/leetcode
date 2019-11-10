package listnode;

/**
 * 142 mid
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 *
 * @author ilovejava1314
 * @date 2019/11/10 15:26
 */
public class LinkedListCycleII {
    /**
     * 双指针法，当存在环时快慢指针始终会重合,重合后让快指针指向表头，
     * 慢指针还是第一次相遇的位置，再进行第二次查找，此时指针没有快慢
     * 依此遍历直至重合，即是环的入口
     *
     * 最优解
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(true) {
            //无环，返回null
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            //第一次重合
            if (slow == fast)
                break;
        }
        //第二次找环入口
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


}
