package linked_lists

fun hasCycle(head: ListNode?): Boolean {
    val checked = 100001
    var current = head
    while (current != null && current.`val` != checked) {
        current.`val` = checked
        current = current.next
    }
    return current != null
}