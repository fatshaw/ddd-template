package com.fatshaw.dddtemplate.infrastructure.repository.po

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "FUND_SPLIT")
@EntityListeners(AuditingEntityListener::class)
data class FundSplitPO(

    @Id
    @Column(name = "ID")
    override var id: String,

    @Column(name = "ACCOUNT_ID")
    val accountId: String,

    @Column(name = "SOURCE_ID")
    val sourceId: String,

    @Column(name = "SOURCE_TYPE")
    val sourceType: String,

    @Column(name = "CURRENCY")
    val currency: String,

    @Column(name = "AMOUNT")
    val amount: BigDecimal,

    @Column(name = "DESTINATION")
    val destination: String,

    @Column(name = "SPLIT_TYPE")
    val type: String? = null,

    @Column(name = "STATUS")
    val status: String

) : BasePO()
