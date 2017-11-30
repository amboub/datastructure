package com.perso.datastructure.tree

import java.util.*
import java.util.Optional.of

class BinaryTree constructor(val value: String) : Tree {
    var rightChild = Optional.empty<BinaryTree>()
    var leftChild = Optional.empty<BinaryTree>()

    fun insertLeft(value: String) {
        if (!leftChild.isPresent) {
            leftChild = of(BinaryTree(value))
        } else {
            val newNode = BinaryTree(value)
            newNode.leftChild = leftChild
            leftChild = of(newNode)
        }
    }
    fun insertRight(value: String) {
        if (!rightChild.isPresent) {
            rightChild = of(BinaryTree(value))
        } else {
            val newNode = BinaryTree(value)
            newNode.rightChild = rightChild
            rightChild = of(newNode)
        }
    }

    override fun toString(): String {
        return "BinaryTree('$value')"
    }
}