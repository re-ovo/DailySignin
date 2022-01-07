package me.rerere.dailysign.model

import java.util.*

data class SigninRecord(
    val id: Long,
    val uuid: UUID,
    val name: String,
    val day: String,
    val timeStamp: Long
)