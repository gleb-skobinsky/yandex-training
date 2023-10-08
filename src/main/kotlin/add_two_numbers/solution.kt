package add_two_numbers

import merge_k_lists.ListNode


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var current1 = l1
    var current2 = l2
    val dummyHead = ListNode(0)
    var tail: ListNode? = dummyHead
    var carry = 0
    while (current1 != null || current2 != null || carry != 0) {
        val digit1 = current1?.`val` ?: 0
        val digit2 = current2?.`val` ?: 0
        val sum = digit1 + digit2 + carry
        val digit = sum % 10 // остаток от деления
        carry = sum / 10 // деление без дробной части, запоминаем "в уме"
        val newNode = ListNode(digit) // остаток складываем в новый узел
        tail!!.next = newNode // новый узел складываем в хвост
        tail = tail.next // сбрасываем хвост
        current1 = current1?.next // обновляем текущие ноды
        current2 = current2?.next
    }
    return dummyHead.next
}