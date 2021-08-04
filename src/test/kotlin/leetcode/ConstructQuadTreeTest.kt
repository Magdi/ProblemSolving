package leetcode

import leetcode.uber.ConstructQuadTree
import org.junit.Test

import org.junit.Assert.*

class ConstructQuadTreeTest {

    @Test
    fun `test case 1`() {
        val constracted = ConstructQuadTree().construct(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)))
        val expected = ConstructQuadTree.Node(
            `val` = true,
            isLeaf = false
        )
        expected.topLeft = ConstructQuadTree.Node(false, true)
        expected.topRight = ConstructQuadTree.Node(true, true)
        expected.bottomLeft = ConstructQuadTree.Node(true, true)
        expected.bottomRight = ConstructQuadTree.Node(false, true)
        assertEquals(expected, constracted)
    }

    @Test
    fun `test case 2`() {
        val constracted = ConstructQuadTree().construct(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))
        val expected = ConstructQuadTree.Node(
            `val` = true,
            isLeaf = true
        )
        assertEquals(expected, constracted)
    }

    @Test
    fun `test case 3`() {
        /**
         * [[1,1,1,1,0,0,0,0],
         * [1,1,1,1,0,0,0,0],
         * [1,1,1,1,1,1,1,1],
         * [1,1,1,1,1,1,1,1]
         * ,[1,1,1,1,0,0,0,0],
         * [1,1,1,1,0,0,0,0],
         * [1,1,1,1,0,0,0,0],
         * [1,1,1,1,0,0,0,0]]
         */
        val constracted = ConstructQuadTree().construct(
            arrayOf(
                intArrayOf(1,1,1,1,0,0,0,0),
                intArrayOf(1,1,1,1,0,0,0,0),
                intArrayOf(1,1,1,1,1,1,1,1),
                intArrayOf(1,1,1,1,1,1,1,1),
                intArrayOf(1,1,1,1,0,0,0,0),
                intArrayOf(1,1,1,1,0,0,0,0),
                intArrayOf(1,1,1,1,0,0,0,0),
                intArrayOf(1,1,1,1,0,0,0,0),
            )
        )
        val expected = ConstructQuadTree.Node(
            `val` = true,
            isLeaf = false,
        )
        expected.topLeft = ConstructQuadTree.Node(true, true)
        expected.topRight = ConstructQuadTree.Node(true, false)

        expected.bottomLeft = ConstructQuadTree.Node(true, true)
        expected.bottomRight = ConstructQuadTree.Node(false, true)


        expected.topRight?.topLeft = ConstructQuadTree.Node(false, true)
        expected.topRight?.topRight = ConstructQuadTree.Node(false, true)
        expected.topRight?.bottomRight = ConstructQuadTree.Node(true, true)
        expected.topRight?.bottomLeft = ConstructQuadTree.Node(true, true)
        assertEquals(expected, constracted)
    }

}