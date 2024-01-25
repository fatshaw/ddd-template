package com.fatshaw.dddtemplate.ddd.common

interface CommandHandler<in C : Command, out R : CommandResult> {
    fun execute(command: C): R
}
