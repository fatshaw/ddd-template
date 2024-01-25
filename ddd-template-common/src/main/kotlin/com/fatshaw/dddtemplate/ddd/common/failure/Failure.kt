package com.fatshaw.dddtemplate.ddd.common.failure

open class Failure(val code: String, val message: String, val exception: Exception? = null)
