package com.example.appyaganaste.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appyaganaste.data.local.database.entity.BankEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BankDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bank: BankEntity)

    @Delete
    suspend fun delete(bank: BankEntity)

    @Query("SELECT name FROM favorite_banks")
    fun getFavoriteBanksNames(): Flow<List<String>>

}