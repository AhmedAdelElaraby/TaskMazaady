package com.workdev.example.ui.SecondScreen.Utils.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workdev.domain.entity.DataModelPosts.DataPost
import com.workdev.example.databinding.ItemCatSecondScreenBinding
import com.workdev.example.databinding.ItemPostBinding
import com.workdev.example.databinding.ItemSecondScreenBinding
import com.workdev.example.databinding.MainCategoryBinding


class AdapterPoster(): RecyclerView.Adapter<AdapterPoster.ViewHolder>() {
    lateinit var  binding:ItemPostBinding
    val adaptersProperties = AdapterCategoryPoster()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      binding= ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.binding.states.text=differ.currentList[position].state
      holder.binding.nameAds.text=differ.currentList[position].name
      holder.binding.time.text=differ.currentList[position].clock
      holder.binding.namePerson.text=differ.currentList[position].namePerson
      holder.binding.Posation.text=differ.currentList[position].Position
      holder.binding.profileImage.setImageResource(differ.currentList[position].image)
      holder.binding.recyclerView.apply {
          layoutManager=LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
          adapter = adaptersProperties
      }
        adaptersProperties.differ.submitList(differ.currentList[position].array)


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(var binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<DataPost>(){
        override fun areItemsTheSame(oldItem:DataPost , newItem: DataPost): Boolean {
            return  oldItem == newItem
        }


        override fun areContentsTheSame(oldItem:DataPost , newItem:DataPost ): Boolean {

            return oldItem == newItem

        }

    }
   val differ = AsyncListDiffer(this,differCallback)








}