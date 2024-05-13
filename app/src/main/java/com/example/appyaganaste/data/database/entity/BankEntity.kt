package com.example.appyaganaste.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_banks")
data class BankEntity(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "age") val age : Int,
    @ColumnInfo(name = "url") val url : String
)