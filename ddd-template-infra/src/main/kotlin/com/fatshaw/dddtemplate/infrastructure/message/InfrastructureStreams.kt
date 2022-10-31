package com.fatshaw.dddtemplate.infrastructure.message

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface InfrastructureStreams {
    companion object {
        const val TEST_SPLIT_OUTPUT = "testSplitOutput"
    }

    @Output(TEST_SPLIT_OUTPUT)
    fun clearingHouseSplitOutput(): MessageChannel
}
