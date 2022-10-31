package com.fatshaw.dddtemplate.domain.fundsplit.facade

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.fundsplit.model.valueobject.SourceStatus

interface FundSplitFacade {
    fun retrieveSourceStatus(fundSplit: FundSplit): SourceStatus
}
