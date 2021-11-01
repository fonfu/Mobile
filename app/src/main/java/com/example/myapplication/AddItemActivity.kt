package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class AddItemActivity: AppCompatActivity(){
    lateinit var addName: EditText
    lateinit var addType: EditText
    lateinit var addDay: EditText
    lateinit var addHour: EditText

    fun viewInitializations() {
        addName = findViewById(R.id.add_name)
        addType = findViewById(R.id.add_type)
        addDay = findViewById(R.id.add_day)
        addHour = findViewById(R.id.add_hour)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_form)
        viewInitializations()

        val addButtonSave = findViewById<Button>(R.id.add_button_save)
        addButtonSave.setOnClickListener{
            val name = addName.text.toString()
            val type = addType.text.toString()
            val day = addDay.text.toString()
            val hour = addHour.text.toString()
            val id = Classes.ITEMS.size

            Classes.addItem(Classes.Class("$id", day, hour, name, type))

            finish()
        }
    }
}