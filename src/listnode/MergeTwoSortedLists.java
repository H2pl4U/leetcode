package listnode;


/**
 * 21. 合并两个有序链表 easy
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author ilovejava1314
 * @date 2019/11/10 17:19
 */
public class MergeTwoSortedLists {
    /**
     * 迭代算法，同时遍历比较
     * O(N+M)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return node.next;
    }

}
