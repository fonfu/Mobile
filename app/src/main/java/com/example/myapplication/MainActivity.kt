package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddMovie = findViewById<Button>(R.id.button2)
        buttonAddMovie.setOnClickListener{
            openAddActivity();
        }

        setupRecyclerView(item_list)

    }

    private fun openAddActivity(){
        val intent = Intent(this, AddItemActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(Classes.ITEMS)
    }

    class SimpleItemRecyclerViewAdapter(
        private var values: MutableList<Classes.Class>
    ) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.dayView.text=item.day
            holder.hourView.text=item.hour
            holder.nameView.text=item.name
            holder.typeView.text=item.type


            with(holder.itemView) {
                tag = item
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val hourView: TextView = view.hour
            val dayView : TextView = view.day
            val nameView: TextView = view.name
            val typeView: TextView = view.type
            private val context: Context = view.context

            init{
                view.findViewById<Button>(R.id.button_remove).setOnClickListener{
                    AlertDialog.Builder(context)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes
                        ) { _, _ ->
                            values.removeAt(bindingAdapterPosition)
                            notifyDataSetChanged()
                        }
                        .setNegativeButton(android.R.string.no, null)
                        .show()
                }

                view.findViewById<Button>(R.id.button_update).setOnClickListener{
                    val intent = Intent(context, UpdateItemActivity::class.java)
                    intent.putExtra("pos", bindingAdapterPosition)
                    context.startActivity(intent)
                }
            }
        }
    }
}