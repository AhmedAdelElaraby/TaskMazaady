package com.workdev.example.ui.main.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiState
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiStateBrand
import com.mg_group.womniz.ResponseDataClass.SealedClass.ApiStateSubCats
import com.workdev.domain.entity.AllCats.Children
import com.workdev.domain.usecase.getAllCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ViewModel @Inject constructor (private val getAllCats: getAllCatsUseCase): ViewModel() {

    private val AllCat : MutableLiveData<ApiState> = MutableLiveData(ApiState.Empty)

    val getAllCatsLiveData : LiveData<ApiState> = AllCat


    fun getAllCats (Key:String){
         viewModelScope.launch {
            AllCat.value = ApiState.Loading
            getAllCats.AllCats(Key).catch {
                AllCat.value=ApiState.Failure(it)
            }.collect{data->
                AllCat.value=ApiState.Success(data)
            }

        }





    }



    private val SubCats :MutableLiveData<List<Children>> = MutableLiveData()
    val getSubCatsLiveData:LiveData<List<Children>> =SubCats

    fun getSubCats (list: List<Children>){
        SubCats.value=list





    }





    private val SubCatsApi : MutableLiveData<ApiStateSubCats> = MutableLiveData(ApiStateSubCats.Empty)

    val SubCatsLiveData : LiveData<ApiStateSubCats> = SubCatsApi


    fun SubCats (Key:String,SubCats:Int){
        viewModelScope.launch {
            SubCatsApi.value = ApiStateSubCats.Loading
            getAllCats.SubCats(Key,SubCats).catch {
                SubCatsApi.value=ApiStateSubCats.Failure(it)
            }.collect{data->
                SubCatsApi.value=ApiStateSubCats.Success(data)
            }

        }





    }



    private val BrandApi : MutableLiveData<ApiStateBrand> = MutableLiveData(ApiStateBrand.Empty)

    val BrandLiveData : LiveData<ApiStateBrand> = BrandApi


    fun Brand (Key:String,id:Int){
        viewModelScope.launch {
            BrandApi.value = ApiStateBrand.Loading
            getAllCats.Brand(Key,id).catch {
                BrandApi.value=ApiStateBrand.Failure(it)
            }.collect{data->
                BrandApi.value=ApiStateBrand.Success(data)
            }

        }





    }





}