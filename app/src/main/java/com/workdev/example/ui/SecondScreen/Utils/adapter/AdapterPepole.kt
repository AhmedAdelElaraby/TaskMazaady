package com.workdev.example.ui.SecondScreen.Utils.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.example.databinding.ItemSecondScreenBinding
import com.workdev.example.databinding.MainCategoryBinding


class AdapterPepole(): RecyclerView.Adapter<AdapterPepole.ViewHolder>() {
    lateinit var  binding:ItemSecondScreenBinding




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemSecondScreenBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.binding.image.setImageResource(differ.currentList[position])




    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemSecondScreenBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem:Int , newItem:Int ): Boolean {
            return  oldItem == newItem
        }


        override fun areContentsTheSame(oldItem:Int , newItem:Int ): Boolean {

            return oldItem == newItem

        }

    }
   val differ = AsyncListDiffer(this,differCallback)








}