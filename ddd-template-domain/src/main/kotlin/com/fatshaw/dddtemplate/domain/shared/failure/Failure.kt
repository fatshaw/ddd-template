package com.fatshaw.dddtemplate.domain.shared.failure

open class Failure(val code: String, val message: String, val exception: Exception? = null)
