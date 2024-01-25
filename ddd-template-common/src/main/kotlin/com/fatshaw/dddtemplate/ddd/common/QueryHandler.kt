package com.fatshaw.dddtemplate.ddd.common

interface QueryHandler<in Q : Query, out R : QueryResult> {
    fun query(query: Q): R
}
