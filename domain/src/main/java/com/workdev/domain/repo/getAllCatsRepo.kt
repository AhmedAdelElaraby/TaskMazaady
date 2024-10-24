package com.workdev.domain.repo

import com.workdev.domain.entity.AllCats.DataAllCats
import com.workdev.domain.entity.Brand.DataBrand
import com.workdev.domain.entity.SubCats.DataSubCats

interface getAllCatsRepo {

    suspend fun getAllCats(Key:String) : DataAllCats
    suspend fun getSubCats(key:String,SubCats:Int): DataSubCats
    suspend fun getBrand(key:String,id:Int): DataBrand
}