package com.mg_group.womniz.ResponseDataClass.SealedClass

import com.workdev.domain.entity.AllCats.DataAllCats


sealed class ApiState {
    object Loading : ApiState()
    class  Success(val data: DataAllCats) : ApiState()
     class Failure(val e: Throwable?) : ApiState()
   object Empty : ApiState()

}
