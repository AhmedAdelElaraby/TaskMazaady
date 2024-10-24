package com.mg_group.womniz.ResponseDataClass.SealedClass

import com.workdev.domain.entity.AllCats.DataAllCats
import com.workdev.domain.entity.Brand.DataBrand


sealed class ApiStateBrand {
    object Loading : ApiStateBrand()
    class  Success(val data: DataBrand) : ApiStateBrand()
     class Failure(val e: Throwable?) : ApiStateBrand()
   object Empty : ApiStateBrand()

}
