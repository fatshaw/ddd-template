package com.fatshaw.dddtemplate.domain.fundsplit.model.event

import com.fatshaw.dddtemplate.ddd.common.SpringDomainEvent
import com.fatshaw.dddtemplate.domain.fundsplit.model.aggregateroot.FundSplit

class FundSplitDomainEvent(payload: FundSplit) :
    SpringDomainEvent<FundSplit>(payload)


