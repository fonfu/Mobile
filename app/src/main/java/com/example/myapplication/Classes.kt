package com.example.myapplication

import java.util.*

object Classes {
    val ITEMS: MutableList<Class> = ArrayList()
    val ITEM_MAP: MutableMap<String, Class> = HashMap()

    private const val COUNT = 5

    init {
        for (i in 1..COUNT) {
            addItem(createClass(i))
        }
    }

    data class Class(val id: String, val day: String, val hour: String, val name: String, val type: String) {
        override fun toString(): String = "$day $hour $name $type"
    }

    private fun createClass(position: Int): Class {
        val random = Random()
        return Class(position.toString(), "Monday", "13:00", "LFTC$position", "Curs")
    }

    fun addItem(item: Class) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    fun updateItem(item: Class, position: Int) {
        ITEMS[position] = item
        ITEM_MAP[item.id] = item
    }
}