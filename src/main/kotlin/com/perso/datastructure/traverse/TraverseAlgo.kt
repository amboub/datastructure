package com.perso.datastructure.traverse

import com.perso.datastructure.tree.Tree
import java.util.*

object TraverseAlgo {
    fun dfsPreOrder(node: Tree) {
        println(node)
        if (node.leftChild.isPresent) {
            dfsPreOrder(node.leftChild.get())
        }
        if (node.rightChild.isPresent) {
            dfsPreOrder(node.rightChild.get())
        }
    }

    fun dfsInOrder(node: Tree) {
        if (node.leftChild.isPresent) {
            dfsInOrder(node.leftChild.get())
        }
        println(node)
        if (node.rightChild.isPresent) {
            dfsInOrder(node.rightChild.get())
        }
    }

    fun dfsPostOrder(node: Tree) {
        if (node.leftChild.isPresent) {
            dfsPostOrder(node.leftChild.get())
        }
        if (node.rightChild.isPresent) {
            dfsPostOrder(node.rightChild.get())
        }
        println(node)
    }

    fun bfs(node: Tree) {
        val queue = LinkedList<Tree>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val current = queue.remove()
            println(current)

            if (current.leftChild.isPresent) {
                queue.add(current.leftChild.get())
            }
            if (current.rightChild.isPresent) {
                queue.add(current.rightChild.get())
            }
        }
    }

//    fun leftDepth(node: SearchBinaryTree): Int {
//        if (node.leftChild.isPresent) {
//            leftDepth(node.leftChild.get())
//        }
//    }
}