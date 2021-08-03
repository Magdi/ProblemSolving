package leetcode

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class RotatingtheBoxTest {

    @Test
    fun `test case 1`() {
        val res = RotatingtheBox().rotateTheBox(arrayOf(charArrayOf('#', '.', '#')))

        val expected = arrayOf(
            charArrayOf('.'),
            charArrayOf('#'),
            charArrayOf('#'),
        )
        assertArrayEquals(
            expected, res
        )
    }

    @Test
    fun `test case 2`() {
        val res = RotatingtheBox().rotateTheBox(
            arrayOf(
                charArrayOf('#', '.', '*', '.'),
                charArrayOf('#', '#', '*', '.'),

                )
        )

        val expected = arrayOf(
            charArrayOf('#', '.'),
            charArrayOf('#', '#'),
            charArrayOf('*', '*'),
            charArrayOf('.', '.'),
        )
        assertArrayEquals(
            expected, res
        )
    }

    @Test //[['#','#','*','.','*','.'],['#','#','#','*','.','.'],['#','#','#','.','#','.']]
    fun `test case 3`() {
        val res = RotatingtheBox().rotateTheBox(
            arrayOf(
                charArrayOf('#', '#', '*', '.', '*', '.'),
                charArrayOf('#', '#', '#', '*', '.', '.'),
                charArrayOf('#', '#', '#', '.', '#', '.'),
            )
        )
//[['.','#','#'],['#','#','#'],['#','#','*'],['#','*','.'],['.','.','*'],['#','.','.']]
        val expected = arrayOf(
            charArrayOf('.','#','#'),
            charArrayOf('.','#','#'),
            charArrayOf('#','#','*'),
            charArrayOf('#','*','.'),
            charArrayOf('#','.','*'),
            charArrayOf('#','.','.'),
        )

        res.forEach {
            it.forEach { print(it) }
            println()
        }
        assertArrayEquals(
            expected, res
        )
    }
}