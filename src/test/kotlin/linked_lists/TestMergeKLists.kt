package linked_lists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestMergeKLists {
    private val input = mutableListOf<ListNode?>(ListNode(1), ListNode(1), ListNode(2))
    private val output = ListNode(1)
    init {
        input[0]!!.next = ListNode(4)
        input[0]!!.next!!.next = ListNode(5)
        input[1]!!.next = ListNode(3)
        input[1]!!.next!!.next = ListNode(4)
        input[2]!!.next = ListNode(6)

        output.next = ListNode(1)
        output.next!!.next = ListNode(2)
        output.next!!.next!!.next = ListNode(3)
        output.next!!.next!!.next!!.next = ListNode(4)
        output.next!!.next!!.next!!.next!!.next = ListNode(4)
        output.next!!.next!!.next!!.next!!.next!!.next = ListNode(5)
        output.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(6)
    }

    @Test
    fun test1() {
        val realOutput = mergeKLists(input)
        assertEquals(output, realOutput)
    }

    @Test
    fun test2() {
        val realOutput2 = mergeKLists2(input)
        assertEquals(output, realOutput2)
    }
}