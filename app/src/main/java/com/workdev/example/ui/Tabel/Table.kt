package com.workdev.example.ui.Tabel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.workdev.example.R
import com.workdev.example.databinding.ActivityTableBinding
import com.workdev.example.ui.Host.SecondScreen
import com.workdev.example.ui.Tabel.utils.AdapterTabel

class Table : AppCompatActivity() {
    lateinit var binding:ActivityTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_table)
        val  intent = intent
       val  selectedItems = intent.getStringArrayListExtra("tabel")
        var Main = intent.getStringExtra("Main")
        var Sub= intent.getStringExtra("Sub")
        var processtype=intent.getStringExtra("processtype")
        var valuoEditRecycler =intent.getStringExtra("valuoEditRecycler")
        selectedItems?.add(Main)
        selectedItems?.add(Sub)
        selectedItems?.add(processtype)
        selectedItems?.add(valuoEditRecycler)

       val adapters = AdapterTabel()
        binding.recTabel.apply {
            layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            adapter = adapters
        }


        adapters.differ.submitList(selectedItems)


        binding.bunDane.setOnClickListener {
            val intent = Intent(this@Table, SecondScreen::class.java)
            startActivity(intent)
}



    }
}