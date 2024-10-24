package com.workdev.example.ui.main.utils


import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.example.databinding.ItemProcessTypeBinding
import java.util.Locale


class AdapterProcessType(private val onClickType: OnClickType,private var items:List<String>): RecyclerView.Adapter<AdapterProcessType.ViewHolder>() {
    lateinit var  binding:ItemProcessTypeBinding
    private var filteredItems: List<String> = items




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemProcessTypeBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textType.setText(filteredItems[position])
        holder.setIsRecyclable(false)


        holder.itemView.setOnClickListener {
            onClickType.OnClickType(filteredItems[position])
        }







    }

    override fun getItemCount(): Int {
        return filteredItems.size
    }




    fun filter(query: String) {
        filteredItems = if (query.isEmpty()) {
            items

        } else {
            items.filter { it.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }


    inner class ViewHolder(var binding: ItemProcessTypeBinding) : RecyclerView.ViewHolder(binding.root)












}