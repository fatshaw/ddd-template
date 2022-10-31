package com.fatshaw.dddtemplate.client.dto

data class PageResponseDto<T>(
    val hasMore: Boolean,
    val items: List<T>
)
