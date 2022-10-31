package com.fatshaw.dddtemplate.client.dto

data class ResponseDto<T>(
    val payload: T? = null,
    val failure: FailureDto = FailureDto()
)