package com.fatshaw.dddtemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import java.util.*

@SpringBootApplication
@EnableAsync
class DDDTemplateApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    runApplication<DDDTemplateApplication>(*args)
}
