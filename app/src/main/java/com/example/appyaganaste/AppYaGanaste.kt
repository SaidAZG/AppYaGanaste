package com.example.appyaganaste

import android.app.Application
import androidx.room.Room
import com.example.appyaganaste.data.local.database.AppDatabase
import java.util.concurrent.Executors

class AppYaGanaste : Application() {
    companion object{
        lateinit var instance: AppYaGanaste
        private set
    }
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app_database")
            .setQueryExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}