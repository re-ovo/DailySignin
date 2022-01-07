package me.rerere.dailysign.datasource.types

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.rerere.dailysign.datasource.IDataSource
import me.rerere.dailysign.model.SigninRecord
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.Exception
import java.util.*

class MysqlSource : IDataSource {
    override suspend fun getPlayerAllSigninRecords(uuid: UUID, startTime: Long): SigninRecord? = withContext(Dispatchers.IO){
        try {
            transaction {

            }
            null
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}