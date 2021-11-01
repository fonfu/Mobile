package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateItemActivity : AppCompatActivity() {
    lateinit var updateName: EditText
    lateinit var updateType: EditText
    lateinit var updateDay: EditText
    lateinit var updateHour: EditText

    fun viewInitializations() {
        updateName = findViewById(R.id.update_name)
        updateType = findViewById(R.id.update_type)
        updateDay = findViewById(R.id.update_day)
        updateHour = findViewById(R.id.update_hour)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_item_form)
        viewInitializations()

        val updateButtonSave = findViewById<Button>(R.id.update_button_save)

        val b: Bundle? = intent.extras
        var pos = -1
        if (b != null) pos = b.getInt("pos")

        val dummyItem = Classes.ITEMS[pos]

        updateName.setText(dummyItem.name)
        updateType.setText(dummyItem.type)
        updateDay.setText(dummyItem.day)
        updateHour.setText(dummyItem.hour)

        updateButtonSave.setOnClickListener {
            val name = updateName.text.toString()
            val type = updateType.text.toString()
            val day = updateDay.text.toString()
            val hour = updateHour.text.toString()


            val updatedDummyItem = Classes.Class("id", day, hour, name, type)
            Classes.updateItem(updatedDummyItem, pos)

            finish()
        }
    }
}