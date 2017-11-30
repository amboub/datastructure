package com.perso.datastructure.tree

import java.util.*
import java.util.Optional.empty
import java.util.Optional.of

class SearchBinaryTree constructor(var value : Optional<Int>) : Tree() {
    init {
        rightChild
        leftChild
    }

    fun insertNode(value: Int) {
        if (rightChild) {
        }
        if (this.value.map({ v -> value <= v }).orElse(false) && this.leftChild.isPresent) {
            (this.leftChild.get() as SearchBinaryTree) .insertNode(value)
        } else if (this.value.map({ v -> value <= v }).orElse(false)) {
            this.leftChild = of(SearchBinaryTree(of(value)))
        } else if (this.value.map({ v -> value > v }).orElse(false) && this.rightChild.isPresent) {
            this.rightChild.get().insertNode(value)
        } else {
            this.rightChild = of(SearchBinaryTree(of(value)))
        }
    }

    fun findNode(value: Int): Optional<SearchBinaryTree> {
        return if (this.value.map({ v -> v > value }).orElse(false) && this.rightChild.isPresent) {
            this.rightChild.get().findNode(value)
        } else if (this.value.map({ v -> value < v }).orElse(false) && this.leftChild.isPresent) {
            this.leftChild.get().findNode(value)
        } else if (this.value.map({ v -> value == v }).orElse(false)) {
            of(this)
        } else {
            empty()
        }
    }

    fun removeNode(value: Int, parent: SearchBinaryTree?) : Boolean {
        return if (this.value.map({ v -> value < v }).orElse(false) && this.leftChild.isPresent) {
            this.leftChild.get().removeNode(value, this)
        } else if (this.value.map({ v -> value < v }).orElse(false)) {
            false
        } else if (this.value.map({ v -> value > v }).orElse(false) && this.rightChild.isPresent) {
            this.rightChild.get().removeNode(value, this)
        } else if (this.value.map({ v -> value > v }).orElse(false)) {
            false
        } else {
            if (this.leftChild.isNotPresent() && this.rightChild.isNotPresent() && this == parent?.leftChild?.get()) {
                parent.leftChild = empty()
                this.clearNode()
            } else if (this.leftChild.isNotPresent() && this.rightChild.isNotPresent() && this == parent?.rightChild?.get()) {
                parent.rightChild = empty()
                this.clearNode()
            } else if (this.leftChild.isPresent && this.rightChild.isNotPresent() && this == parent?.leftChild?.get()) {
                parent.leftChild = this.leftChild
                this.clearNode()
            } else if (this.leftChild.isPresent && this.rightChild.isNotPresent() && this == parent?.rightChild?.get()) {
                parent.rightChild = this.leftChild
                this.clearNode()
            } else if (this.leftChild.isNotPresent() && this.rightChild.isPresent && this == parent?.rightChild?.get()) {
                parent.rightChild = this.rightChild
                this.clearNode()
            } else if (this.leftChild.isNotPresent() && this.rightChild.isPresent && this == parent?.leftChild?.get()) {
                parent.leftChild = this.rightChild
                this.clearNode()
            } else {
                this.value = this.rightChild.get().findMinimumValue().value
                this.rightChild.get().removeNode(this.value.get(), this)
            }
            true
        }
    }

    fun findMinimumValue() : SearchBinaryTree {
        if (this.leftChild.isPresent) {
            return this.leftChild.get().findMinimumValue()
        }
        return this
    }

    fun clearNode() {
        this.value = empty()
        this.leftChild = empty()
        this.rightChild = empty()
    }

    override fun toString(): String {
        return "|$value|"
    }

    fun Optional<out Any>.isNotPresent(): Boolean = !this.isPresent
}