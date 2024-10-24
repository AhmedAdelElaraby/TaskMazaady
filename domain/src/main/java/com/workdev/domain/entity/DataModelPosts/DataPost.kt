package com.workdev.domain.entity.DataModelPosts

data class DataPost(
    val state:String,
    val name:String,
    val clock:String,
    val array: List<String>,
    val image:Int,
    val namePerson:String,
    val Position:String
)