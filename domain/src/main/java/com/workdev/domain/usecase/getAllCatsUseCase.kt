package com.workdev.domain.usecase

import com.workdev.domain.entity.AllCats.DataAllCats
import com.workdev.domain.entity.Brand.DataBrand
import com.workdev.domain.entity.SubCats.DataSubCats
import com.workdev.domain.repo.getAllCatsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class getAllCatsUseCase(private val  Cats: getAllCatsRepo) {


    suspend  fun AllCats(Key:String) = flow<DataAllCats> {
        emit( Cats.getAllCats(Key))
    }.flowOn(Dispatchers.IO)

    suspend  fun SubCats(Key:String,SubCats:Int) = flow<DataSubCats> {
        emit( Cats.getSubCats(Key,SubCats))
    }.flowOn(Dispatchers.IO)


    suspend  fun Brand(Key:String,id:Int) = flow<DataBrand> {
        emit( Cats.getBrand(Key,id))
    }.flowOn(Dispatchers.IO)
}