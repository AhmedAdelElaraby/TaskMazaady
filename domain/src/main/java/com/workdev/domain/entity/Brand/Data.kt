package com.workdev.domain.entity.Brand

data class Data(
    val description: Any,
    val id: Int,
    val list: Boolean,
    val name: String,
    val options: ArrayList<Option>,
    val other_value: Any,
    val parent: Int,
    val slug: String,
    val type: Any,
    val value: String
)