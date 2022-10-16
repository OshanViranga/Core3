package com.example.core3

import android.content.Context
import android.net.wifi.p2p.WifiP2pManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class TheAdapter(private val data: List<Country>): RecyclerView.Adapter<TheAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.activity_list, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val name = v.findViewById<TextView>(R.id.name)
        val medals = v.findViewById<TextView>(R.id.medals)

        fun bind(item: Country) {
            val num = item.gold + item.silver + item.bronze
            if (num > 100) {
                name.setBackgroundColor(-7829368)
                medals.setBackgroundColor(-7829368)
            }

            name.text = "${item.name}\n${item.code}"
            medals.text = "${num.toString()}\n"

            v.setOnClickListener{

                Snackbar.make(it, "${item.name} has ${item.gold} gold medals.", Snackbar.LENGTH_SHORT).show()

                val sharedPref = v.context.getSharedPreferences("preferences", Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    putString("name", item.name)
                    apply()
                }
            }
        }
    }
}