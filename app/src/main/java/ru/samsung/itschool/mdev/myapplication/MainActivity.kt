package ru.samsung.itschool.mdev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var persons: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fileString = application.assets.open("test.json").bufferedReader().use{ it.readText() }
        val gson = GsonBuilder().create()
        persons = gson.fromJson(fileString,Array<Person>::class.java).toList()
        Log.d("RRR",persons.size.toString())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(persons)
        recyclerView.adapter = adapter
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        sortBy()
    }
    fun sortBy() {
        btn1.setOnClickListener {
            recyclerView.adapter = CustomAdapter(persons.sortedBy { it.name })
        }
        btn2.setOnClickListener {
            recyclerView.adapter = CustomAdapter(persons.sortedBy { it.phoneNumber })
        }
        btn3.setOnClickListener {
            recyclerView.adapter = CustomAdapter(persons.sortedBy { it.sex })
        }
    }
}