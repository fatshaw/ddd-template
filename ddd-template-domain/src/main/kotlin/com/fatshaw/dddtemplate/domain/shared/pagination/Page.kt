package com.fatshaw.dddtemplate.domain.shared.pagination

data class Page<T>(
    val hasNext: Boolean,
    val items: List<T>
)
