package com.gsixacademy.android.myfirebaseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val listAdapter  = ListAdapter(ArrayList())
        recycler_view_main.adapter = listAdapter
    }
}