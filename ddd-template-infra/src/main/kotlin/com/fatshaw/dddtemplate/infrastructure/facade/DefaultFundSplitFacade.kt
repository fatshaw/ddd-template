package com.fatshaw.dddtemplate.infrastructure.facade

import com.fatshaw.dddtemplate.domain.fundsplit.facade.FundSplitFacade
import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceStatus
import org.springframework.stereotype.Service

@Service
class DefaultFundSplitFacade : FundSplitFacade {
    override fun retrieveSourceStatus(fundSplit: FundSplit): SourceStatus {
        // TODO
        return SourceStatus.PENDING
    }
}
