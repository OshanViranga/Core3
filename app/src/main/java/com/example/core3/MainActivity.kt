package com.example.core3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = initData()

        val listView = findViewById<RecyclerView>(R.id.list)

        listView.adapter = TheAdapter(data)
        listView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu -> {
                val intent = Intent(this, OptionActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initData(): List<Country> {
        val list = mutableListOf<Country>()
        resources.openRawResource(R.raw.medallists).bufferedReader()
            .forEachLine {
                val temp = it.split(",")
                list.add(
                    Country(
                        temp[0],
                        temp[1],
                        temp[2].toInt(),
                        temp[3].toInt(),
                        temp[4].toInt(),
                        temp[5].toInt()
                    )
                )
            }
        return list
    }
}

