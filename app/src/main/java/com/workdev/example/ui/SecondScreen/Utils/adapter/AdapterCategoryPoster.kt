package com.workdev.example.ui.SecondScreen.Utils.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.example.databinding.ItemCatSecondScreenBinding
import com.workdev.example.databinding.ItemPropertiesBinding
import com.workdev.example.databinding.ItemSecondScreenBinding
import com.workdev.example.databinding.MainCategoryBinding


class AdapterCategoryPoster(): RecyclerView.Adapter<AdapterCategoryPoster.ViewHolder>() {
    lateinit var  binding:ItemPropertiesBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemPropertiesBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.binding.text.setText(differ.currentList[position])




    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemPropertiesBinding) : RecyclerView.ViewHolder(binding.root)


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