package me.rerere.dailysign.datasource

import me.rerere.dailysign.model.SigninRecord
import java.util.*

interface IDataSource {
    /**
     * Get all signin records from datasource
     *
     * @param uuid Player UUID
     * @param startTime Return the signin record after what date
     * @return All match signin records of player
     */
    suspend fun getPlayerAllSigninRecords(
        uuid: UUID,
        startTime: Long = 0L
    ): SigninRecord?
}