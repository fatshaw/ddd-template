package com.fatshaw.dddtemplate.application.commandhandler

import com.fatshaw.dddtemplate.application.command.CancelFundSplitCommand
import com.fatshaw.dddtemplate.application.command.CancelFundSplitCommandResult
import com.fatshaw.dddtemplate.application.failure.ApplicationFailure
import com.fatshaw.dddtemplate.ddd.common.CommandHandler
import io.vavr.control.Either.left
import org.springframework.stereotype.Service

@Service
class CancelFundSplitCommandHandler(
    val fundSplitService: com.fatshaw.dddtemplate.domain.fundsplit.service.FundSplitService,
    val fundSplitRepository: com.fatshaw.dddtemplate.domain.fundsplit.repository.FundSplitRepository
) : CommandHandler<CancelFundSplitCommand, CancelFundSplitCommandResult> {
    override fun execute(command: CancelFundSplitCommand): CancelFundSplitCommandResult {

        val fundSplit = fundSplitRepository.findById(command.fundSplitId) ?: return CancelFundSplitCommandResult(
            left(ApplicationFailure.FundSplitNotFound)
        )

        if (fundSplit.accountId != command.accountId) return CancelFundSplitCommandResult(
            left(ApplicationFailure.NoPermission)
        )

        return CancelFundSplitCommandResult(fundSplitService.cancelFundSplit(fundSplit))
    }
}
