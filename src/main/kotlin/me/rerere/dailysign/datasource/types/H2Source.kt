package me.rerere.dailysign.datasource.types

import me.rerere.dailysign.datasource.IDataSource
import me.rerere.dailysign.model.SigninRecord
import java.util.*

class H2Source : IDataSource {
    override suspend fun getPlayerAllSigninRecords(uuid: UUID, startTime: Long): SigninRecord? {
        TODO("Not yet implemented")
    }
}