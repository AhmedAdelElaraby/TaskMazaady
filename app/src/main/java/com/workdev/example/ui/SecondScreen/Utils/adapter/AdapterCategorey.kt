package com.workdev.example.ui.SecondScreen.Utils.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workdev.example.R
import com.workdev.example.databinding.ItemCatSecondScreenBinding
import com.workdev.example.databinding.ItemSecondScreenBinding
import com.workdev.example.databinding.MainCategoryBinding


class AdapterCategorey(): RecyclerView.Adapter<AdapterCategorey.ViewHolder>() {
    lateinit var  binding:ItemCatSecondScreenBinding

    private var selectedItemPosition = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemCatSecondScreenBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.binding.name.setText(differ.currentList[position])

        holder.setIsRecyclable(false)
        holder.binding.constraint.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
        }
        if(selectedItemPosition == position) {

            binding.constraint.background = holder.itemView.context.getDrawable(R.drawable.item_back_icon_home_selected)

            // Toast.makeText(context, ""+differ.currentList[position].toString(), Toast.LENGTH_LONG).show()
        }
        else {

            binding.constraint.background = holder.itemView.context.getDrawable(R.drawable.item_back_icon_home)

            // Toast.makeText(context, ""+differ.currentList[position].name, Toast.LENGTH_LONG).show()

        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemCatSecondScreenBinding) : RecyclerView.ViewHolder(binding.root)


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