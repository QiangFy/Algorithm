package leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author qiangfei
 * @date 2022/5/13 14:42
 */
public class Solution00019 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *  
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *  
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *  
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *  
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode one = head;
        ListNode two = head;
        while (one != null) {
            one = one.next;
            if (n-- < 0) {
                two = two.next;
            }
        }
//        n >= 0说明要删除头结点
        if (n < 0) {
            two.next = two.next.next;
            return head;
        }
        return head.next;
    }


    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
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
}
