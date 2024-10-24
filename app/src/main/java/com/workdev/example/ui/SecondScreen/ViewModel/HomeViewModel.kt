package com.workdev.example.ui.SecondScreen.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.workdev.domain.entity.DataModelPosts.DataPost

class HomeViewModel : ViewModel() {
    private var Images: MutableLiveData<List<Int>> = MutableLiveData<List<Int>> ()

    val ImagesLive: LiveData<List<Int>> = Images



    fun Images(Image:List<Int>){

        Images.value = Image




    }



    private var Text: MutableLiveData<List<String>> = MutableLiveData<List<String>> ()

    val TextLive: LiveData<List<String>> = Text




    fun Text(text:List<String>){

        Text.value = text




    }




    private var Posters: MutableLiveData<List<DataPost>> = MutableLiveData<List<DataPost>> ()

    val PostersLive: LiveData<List<DataPost>> = Posters




    fun Poster(text:List<DataPost>){

        Posters.value = text




    }



}