package com.workdev.example.ui.main.View

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiState
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiStateBrand
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiStateSubCats
import com.workdev.domain.entity.AllCats.Category
import com.workdev.domain.entity.AllCats.Children
import com.workdev.domain.entity.Brand.Option
import com.workdev.example.R
import com.workdev.example.databinding.ActivityMainBinding
import com.workdev.example.databinding.ItemMainProcessTypeBinding
import com.workdev.example.ui.Tabel.Table
import com.workdev.example.ui.main.ViewModel.ViewModel
import com.workdev.example.ui.main.utils.AdapterProcess
import com.workdev.example.ui.main.utils.AdapterProcessType
import com.workdev.example.ui.main.utils.OnClick
import com.workdev.example.ui.main.utils.OnClickType
import com.workdev.example.utils.Const
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale


@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,OnClickType,OnClick {
    lateinit var binding: ActivityMainBinding
    val array = ArrayList<Category>()
    val Children = ArrayList<Children>()



    private val viewModel: ViewModel by viewModels()
    val arrayBrand = ArrayList<Option>()
    var SubCats:String =""
    var MainCats:String = ""
    var ProcessType:String= ""
    var valuoEditRecycler:String = ""
    var arrayType=  ArrayList<String>()
    var  adaptersType=AdapterProcessType(this,arrayType)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getAllCats(Const.PrivateKey)
        binding.BrandLabel.visibility=View.VISIBLE
        val adapters = AdapterProcess(this,this)




        binding.autoCompleteMainCategory.setOnItemClickListener { parent, view, position, id ->
            MainCats = array.get(position).name
            val selectedCategory = array.get(position).children

           viewModel.getSubCats(selectedCategory)
        }

        binding.autoCompleteSubCategory.setOnItemClickListener { parent, view, position, id ->

            SubCats = Children.get(position).name
            val selectedCategory = Children.get(position).id
            viewModel.SubCats(Const.PrivateKey,selectedCategory)
//            viewModel.getSubCats(selectedCategory)
        }

        binding.recProcess.apply {
            layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            adapter=adapters


        }

    binding.bunDane.setOnClickListener {
        val list=adapters.getItemSelected()
       val intent =Intent(this@MainActivity, Table::class.java)
        intent.putStringArrayListExtra("tabel", list)
        intent.putExtra("Main", MainCats)
        intent.putExtra("Sub", SubCats)
        intent.putExtra("processtype",ProcessType)
        intent.putExtra("valuoEditRecycler",valuoEditRecycler)
        startActivity(intent)
    }


        binding.autoCompleteProcess.setOnClickListener {

            SuccassSendDeleted()

        }

        viewModel.getAllCatsLiveData.observe(this) {
            when (it) {
                is ApiState.Loading -> {

                }

                is ApiState.Failure -> {

                    Toast.makeText(this, "" + it.e?.message.toString(), Toast.LENGTH_LONG).show()
                }

                is ApiState.Success -> {
                    it.data.data.categories.forEach {
                        array.add(it)
                    }

                    val categoryNames = it.data.data.categories.map { it.name }

                    val ArrayAdapter = ArrayAdapter(this, R.layout.main_category, categoryNames)
                    binding.autoCompleteMainCategory.setAdapter(ArrayAdapter)


                }

                is ApiState.Empty -> {

                }

                else -> {

                }
            }


        }

        viewModel.getSubCatsLiveData.observe(this) {it->
            it.forEach {
                Children.add(it)
            }
            val SubCats = it.map { it.name }
            val ArrayAdapter = ArrayAdapter(this, R.layout.main_category, SubCats)
            binding.autoCompleteSubCategory.setAdapter(ArrayAdapter)


        }

        viewModel.SubCatsLiveData.observe(this@MainActivity) {
            when (it) {
                is ApiStateSubCats.Loading -> {

                }

                is ApiStateSubCats.Failure -> {

                    Toast.makeText(this, "" + it.e?.message.toString(), Toast.LENGTH_LONG).show()
                }

                is ApiStateSubCats.Success -> {
                    arrayType.clear()
                    val data=it.data.data.get(0).options.map { it.name}
                    data.forEach{
                        arrayType.add(it)
                    }


                    adapters.differ.submitList(it.data.data.subList(1,it.data.data.size))

                }

                is ApiStateSubCats.Empty -> {

                }

                else -> {

                }
            }


        }

        viewModel.BrandLiveData.observe(this@MainActivity) {
            when (it) {
                is ApiStateBrand.Loading -> {

                }

                is ApiStateBrand.Failure -> {

                    Toast.makeText(this, "" + it.e?.message.toString(), Toast.LENGTH_LONG).show()
                }

                is ApiStateBrand.Success -> {


                    if (it.data.data.isNullOrEmpty()){

                    }
                    else {
                        val data = it.data.data.get(0).options

                        data.forEach {
                            arrayBrand.add(it)
                        }
                        val Brand = arrayBrand.map { it.name }
                        val ArrayAdapter = ArrayAdapter(this, R.layout.main_category, Brand)
                        binding.Bruand.setAdapter(ArrayAdapter)
                    }



                }

                is ApiStateBrand.Empty -> {

                }

                else -> {

                }
            }


        }

    }


    fun SuccassSendDeleted() {

        val dialogBinding: ItemMainProcessTypeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.item_main_process_type, null, false)
        val dialog = AlertDialog.Builder(this).setView(dialogBinding.root)

        dialogBinding.reccode.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        dialogBinding.reccode.adapter = adaptersType
       dialogBinding.editTextSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Not used
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {


                adaptersType.filter(newText  ?: "")


                return false
            }
        })

            val d= dialog.create().window
                d!!.setGravity(Gravity.BOTTOM)
                 d.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    dialog.show()




    }

    override fun OnClickType(name: String) {
       if (name == "other"){
           ProcessType=name
           valuoEditRecycler= binding.textInputEditText.text.toString()
           binding.Spaclfy.visibility=View.VISIBLE
           binding.label.setHint(name)


       }
        else{
           ProcessType=name
           binding.Spaclfy.visibility=View.GONE
           binding.label.setHint(name)


       }
    }

    override fun OnClick(id: Int) {
        viewModel.Brand(Const.PrivateKey,id)
    }



}