package com.fatshaw.dddtemplate.domain.shared

interface QueryHandler<in Q : Query, out R : QueryResult> {
    fun query(query: Q): R
}
