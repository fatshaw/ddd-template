package com.fatshaw.dddtemplate.infrastructure.message

import com.fatshaw.dddtemplate.infrastructure.message.InfrastructureStreams.Companion.TEST_SPLIT_OUTPUT
import com.fatshaw.dddtemplate.infrastructure.message.dto.SyncFundSplitsDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

@Service
@EnableBinding(InfrastructureStreams::class)
class ClearinghouseFundSplitPublisher(
    @Qualifier(TEST_SPLIT_OUTPUT) private val testSplitOutput: MessageChannel
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Retryable
    fun publish(event: SyncFundSplitsDto) {
        logger.info("send testSplitOutput, event=${event}")
        testSplitOutput.send(MessageBuilder.withPayload(event).build())
    }
}
