package com.fatshaw.dddtemplate.ddd.common.pagination

data class Page<T>(
    val hasNext: Boolean,
    val items: List<T>
)
