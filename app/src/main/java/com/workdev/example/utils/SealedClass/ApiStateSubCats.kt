package com.mg_group.womniz.ResponseDataClass.SealedClass

import com.workdev.domain.entity.AllCats.DataAllCats
import com.workdev.domain.entity.SubCats.DataSubCats


sealed class ApiStateSubCats {
    object Loading : ApiStateSubCats()
    class  Success(val data: DataSubCats) : ApiStateSubCats()
     class Failure(val e: Throwable?) : ApiStateSubCats()
   object Empty : ApiStateSubCats()

}
