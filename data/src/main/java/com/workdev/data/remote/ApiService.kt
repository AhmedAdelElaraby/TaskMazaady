package com.workdev.data.remote

import com.workdev.domain.entity.AllCats.DataAllCats
import com.workdev.domain.entity.Brand.DataBrand
import com.workdev.domain.entity.SubCats.DataSubCats
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("get_all_cats")
    suspend fun getAllCats(@Header("private-key") Key:String) : DataAllCats

    @GET("properties")
    suspend fun getSubCats(@Header("private-key") Key:String, @Query("cat") subCat:Int) : DataSubCats

    @GET("get-options-child/{id}")
    suspend fun getbrand(@Header("private-key") Key:String, @Path("id") id:Int) : DataBrand

}