package com.fatshaw.dddtemplate.domain.fundsplit.service

import com.fatshaw.dddtemplate.domain.fundsplit.facade.FundSplitFacade
import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitEvent.ON_CANCEL
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.FundSplitEvent.ON_CREATE
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceStatus.PENDING
import com.fatshaw.dddtemplate.domain.fundsplit.repository.FundSplitRepository
import com.fatshaw.dddtemplate.domain.shared.DomainService
import com.fatshaw.dddtemplate.domain.shared.failure.DomainFailure.SourceStatusInvalid
import com.fatshaw.dddtemplate.domain.shared.failure.Failure
import io.vavr.control.Either
import io.vavr.control.Either.left
import io.vavr.control.Either.right
import org.springframework.stereotype.Service

@Service
class FundSplitService(
    val fundSplitRepository: FundSplitRepository,
    val fundSplitFacade: FundSplitFacade
) : DomainService {

    fun createFundSplit(fundSplit: FundSplit): Either<Failure, FundSplit> {
        val sourceStatus = fundSplitFacade.retrieveSourceStatus(fundSplit)
        return if (sourceStatus == PENDING) {
            fundSplit.apply(ON_CREATE)
            right(fundSplitRepository.save(fundSplit))
        } else {
            left(SourceStatusInvalid)
        }
    }

    fun cancelFundSplit(fundSplit: FundSplit): Either<Failure, FundSplit> {
        val sourceStatus = fundSplitFacade.retrieveSourceStatus(fundSplit)
        return if (sourceStatus == PENDING) {
            fundSplit.apply(ON_CANCEL)
            right(fundSplitRepository.save(fundSplit))
        } else {
            left(SourceStatusInvalid)
        }
    }
}
