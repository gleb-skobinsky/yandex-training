package merge_k_lists

import java.util.*

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun mergeKLists(lists: MutableList<ListNode?>): ListNode? {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }

    fun merge(left: Int, right: Int): ListNode? {
        if (left == right) return lists[left]
        if (left + 1 == right) return mergeTwoLists(lists[left], lists[right])

        val mid = (left + right) / 2
        val leftMerged = merge(left, mid)
        val rightMerged = merge(mid + 1, right)

        return mergeTwoLists(leftMerged, rightMerged)
    }
    if (lists.isEmpty()) return null
    return merge(0, lists.size - 1)
}

fun mergeKLists2(lists: MutableList<ListNode?>): ListNode? {
    val k = lists.size + 1 // количество нод в конечном списке
    val minHeap = PriorityQueue<ListNode>(k, compareBy { it.`val` })
    lists.forEach { headNode ->
        if (headNode != null) minHeap.offer(headNode)
    }

    var result: ListNode? = null
    var resultBuilder = result
    while (minHeap.size > 0) {
        val nextNode = minHeap.poll()
        if (result == null) {
            result = nextNode
            resultBuilder = nextNode
        } else {
            resultBuilder!!.next = nextNode
            resultBuilder = nextNode
        }
        if (nextNode.next != null) {
            minHeap.offer(nextNode.next)
        }
    }

    return result
}