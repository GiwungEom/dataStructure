package com.gw.study.datastructure.list

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class LinkedListTest {

    private val compare: (Int, Int) -> Int = { e1, e2 -> e1 - e2 }
    private lateinit var linkedList: GwLinkedList<Int>
    private lateinit var linkedListOrder: GwLinkedList<Int>
    private val dataSize = 10

    @Before
    fun initialize() {
        linkedList = GwLinkedList()
        linkedListOrder = GwLinkedList(compare)
        insertData()
    }

    private fun insertData(times: Int = dataSize) {
        repeat(times) {
            linkedList.insert(it)
        }
    }

    @Test
    fun linkedList_numberOfData_equalsTrue() {
        assertEquals(dataSize, linkedList.numberOfData)
    }

    @Test
    fun linkedList_first_equalsTrue() {
        assertEquals(dataSize - 1, linkedList.first())
    }

    @Test
    fun linkedList_next_equalsTrue() {
        for (i in dataSize - 1 downTo 0) {
            if (i == dataSize - 1) {
                assertEquals(i, linkedList.first())
            } else {
                assertEquals(i, linkedList.next())
            }
        }
    }

    @Test
    fun linkedList_remove_equalsTrue() {
        with(linkedList) {
            for (i in dataSize - 1 downTo 0) {
                if (i == dataSize - 1) {
                    first()
                    assertEquals(i, remove())
                } else {
                    next()
                    assertEquals(i, remove())
                }
            }
        }
    }


    /** LinkedList Compare Insert Start  **/
    private fun GwLinkedList<Int>.generateReversedData() {
        var index = 0
        repeat(dataSize) {
            insert((dataSize - 1) - index++)
        }
    }

    @Test
    fun linkedList_insert_equalsTrue() {
        linkedListOrder.generateReversedData()
        assertEquals(0, linkedListOrder.first())
    }

    @Test
    fun linkedList_search_equalsTrue() {
        linkedListOrder.generateReversedData()
        repeat(dataSize) {
            if (it == 0) assertEquals(it, linkedListOrder.first())
            else assertEquals(it, linkedListOrder.next())
        }
    }
}