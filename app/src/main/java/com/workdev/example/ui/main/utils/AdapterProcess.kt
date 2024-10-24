package com.workdev.example.ui.main.utils


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.domain.entity.SubCats.Data
import com.workdev.example.R
import com.workdev.example.databinding.ItemProcessBinding


class AdapterProcess(private val context: Context,private val  onClick: OnClick): RecyclerView.Adapter<AdapterProcess.ViewHolder>() {
    lateinit var  binding:ItemProcessBinding
    val list=ArrayList<String>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemProcessBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = differ.currentList[position]

            holder.binding.label.setHint(item.name)
            val name = item.options.map { it.name }
            holder.setIsRecyclable(false)
            val adapter = ArrayAdapter(context, R.layout.main_category, name)
            holder.binding.autoCompleteProcess.setAdapter(adapter)


        binding.autoCompleteProcess.setOnItemClickListener { parent, view, position, id ->
            onClick.OnClick(item.options.get(position).id)
            val selectedItem = parent.getItemAtPosition(position) as String
            item.name =selectedItem
            addSelectedItem(selectedItem)
        }






    }


    private fun addSelectedItem(item: String) {
        if (!list.contains(item)) { // Prevent duplicates
            list.add(item)
        }
    }

    fun getItemSelected():ArrayList<String>{
        return list

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemProcessBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem:Data , newItem:Data ): Boolean {
            return  oldItem == newItem
        }


        override fun areContentsTheSame(oldItem:Data , newItem:Data ): Boolean {

            return oldItem == newItem

        }

    }
   val differ = AsyncListDiffer(this,differCallback)








}