package com.fatshaw.dddtemplate.client.rpc

import com.fatshaw.dddtemplate.client.dto.FundSplitDto
import com.fatshaw.dddtemplate.client.dto.PageResponseDto
import com.fatshaw.dddtemplate.client.dto.ResponseDto
import com.fatshaw.dddtemplate.client.dto.request.CancelFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.CreateFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.ListFundSplitRequestDto
import com.fatshaw.dddtemplate.client.dto.request.RetrieveFundSplitRequestDto

interface FundSplitRpc {

    fun create(createFundSplitRequestDto: CreateFundSplitRequestDto): ResponseDto<FundSplitDto>

    fun cancel(cancelFundSplitRequestDto: CancelFundSplitRequestDto): ResponseDto<FundSplitDto>

    fun retrieve(retrieveFundSplitRequestDto: RetrieveFundSplitRequestDto): ResponseDto<FundSplitDto>

    fun list(listFundSplitRequestDto: ListFundSplitRequestDto): ResponseDto<PageResponseDto<FundSplitDto>>
}
