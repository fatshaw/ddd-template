package com.fatshaw.dddtemplate.application.commandhandler

import com.fatshaw.dddtemplate.application.command.CreateFundSplitCommand
import com.fatshaw.dddtemplate.application.command.CreateFundSplitCommandResult
import com.fatshaw.dddtemplate.domain.fundsplit.service.FundSplitService
import com.fatshaw.dddtemplate.domain.shared.CommandHandler
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateFundSplitCommandHandler(val fundSplitService: FundSplitService) :
    CommandHandler<CreateFundSplitCommand, CreateFundSplitCommandResult> {

    override fun execute(command: CreateFundSplitCommand): CreateFundSplitCommandResult {
        return CreateFundSplitCommandResult(fundSplitService.createFundSplit(command.buildFundSplit()))
    }

    private fun CreateFundSplitCommand.buildFundSplit() =
        com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit(
            id = "spt_${UUID.randomUUID()}",
            platformAccountId = platformAccountId,
            accountId = accountId,
            sourceId = sourceId,
            sourceType = sourceType,
            currency = currency,
            amount = amount,
            destination = destination,
            type = type
        )
}
