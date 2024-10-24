package com.workdev.domain.entity.SubCats

data class Data(
    val description: String,
    val id: Int,
    val list: Boolean,
    var name: String,
    val options: List<Option>,
    val other_value: Any,
    val parent: Any,
    val slug: String,
    val type: String,
    val value: String
)