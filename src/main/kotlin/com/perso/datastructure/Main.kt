package com.perso.datastructure

import com.perso.datastructure.traverse.TraverseAlgo
import com.perso.datastructure.tree.BinaryTree
import com.perso.datastructure.tree.SearchBinaryTree
import java.util.Optional.of

fun main(args: Array<String>) {
    val nodeA = BinaryTree("1")
    nodeA.insertLeft("2")
    nodeA.insertRight("5")

    val nodeB = nodeA.leftChild
    nodeB.ifPresent { t -> t.insertLeft("3") }
    nodeB.ifPresent { t -> t.insertRight("4") }

    val nodeC = nodeA.rightChild
    nodeC.ifPresent { t -> t.insertLeft("6") }
    nodeC.ifPresent { t -> t.insertRight("7") }

    println("------DSF Pre-Order------")
    TraverseAlgo.dfsPreOrder(nodeA)

    println("------DSF In-Order------")
    TraverseAlgo.dfsInOrder(nodeA)

    println("------DSF Post-Order------")
    TraverseAlgo.dfsPostOrder(nodeA)

    println("------BFS------")
    TraverseAlgo.bfs(nodeA)
    println("---------------")

    val root = SearchBinaryTree(of(15))
    root.insertNode(10)
    root.insertNode(20)
    root.insertNode(8)
    root.insertNode(12)
    root.insertNode(17)
    root.insertNode(25)
    root.insertNode(19)

    println(root.removeNode(17, null))
    TraverseAlgo.bfs(root)
}