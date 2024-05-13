package com.example.appyaganaste.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appyaganaste.data.local.database.dao.BankDao
import com.example.appyaganaste.data.local.database.entity.BankEntity

@Database(entities = [BankEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getBankDao(): BankDao
}