package com.fatshaw.dddtemplate.domain.shared

interface CommandHandler<in C : Command, out R : CommandResult> {
    fun execute(command: C): R
}
