package com.workdev.data.repo

import com.workdev.data.remote.ApiService
import com.workdev.domain.entity.Brand.DataBrand
import com.workdev.domain.entity.SubCats.DataSubCats
import com.workdev.domain.repo.getAllCatsRepo

class getAllCatsRepoImpL(private val apiService: ApiService):getAllCatsRepo {

    override suspend fun getAllCats(Key:String)=apiService.getAllCats(Key)
    override suspend fun getSubCats(key: String, SubCats: Int) = apiService.getSubCats(key,SubCats)
    override suspend fun getBrand(key: String, id: Int) = apiService.getbrand(key,id)


}