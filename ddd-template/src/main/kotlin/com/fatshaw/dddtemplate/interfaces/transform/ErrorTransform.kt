package com.fatshaw.dddtemplate.interfaces.transform

import com.fatshaw.dddtemplate.client.dto.FailureDto
import com.fatshaw.dddtemplate.domain.shared.failure.Failure

fun Failure.toDto() =
    FailureDto(code = code, message = message)
