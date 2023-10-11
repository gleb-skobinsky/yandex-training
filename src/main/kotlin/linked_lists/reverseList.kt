package linked_lists

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    var returnNode: ListNode? = null
    var current: ListNode? = head
    while (current != null) {
        val savedNext = current.next
        current.next = returnNode
        returnNode = current
        current = savedNext
    }
    return returnNode
}