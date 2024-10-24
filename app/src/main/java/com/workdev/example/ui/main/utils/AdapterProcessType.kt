package com.workdev.example.ui.main.utils


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.domain.entity.SubCats.Data
import com.workdev.example.R
import com.workdev.example.databinding.ItemCatSecondScreenBinding
import com.workdev.example.databinding.ItemProcessBinding
import com.workdev.example.databinding.ItemProcessTypeBinding


class AdapterProcessType(private val onClickType: OnClickType): RecyclerView.Adapter<AdapterProcessType.ViewHolder>() {
    lateinit var  binding:ItemProcessTypeBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemProcessTypeBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textType.setText(differ.currentList[position])
        holder.setIsRecyclable(false)
        holder.itemView.setOnClickListener {
            onClickType.OnClickType(differ.currentList[position])
        }







    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemProcessTypeBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem:String , newItem:String ): Boolean {
            return  oldItem == newItem
        }


        override fun areContentsTheSame(oldItem:String , newItem:String ): Boolean {

            return oldItem == newItem

        }

    }
   val differ = AsyncListDiffer(this,differCallback)








}