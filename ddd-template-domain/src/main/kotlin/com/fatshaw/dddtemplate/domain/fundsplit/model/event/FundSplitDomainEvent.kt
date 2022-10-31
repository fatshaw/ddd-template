package com.fatshaw.dddtemplate.domain.fundsplit.model.event

import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit
import com.fatshaw.dddtemplate.domain.shared.SpringDomainEvent

class FundSplitDomainEvent(payload: FundSplit) :
    SpringDomainEvent<FundSplit>(payload)


